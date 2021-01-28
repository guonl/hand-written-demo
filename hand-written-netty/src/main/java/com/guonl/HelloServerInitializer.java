package com.guonl;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;


/**
 * 功能：初始化器，channel注册之后，会执行里面相应的初始化方法（也就是将handler逐一添加）
 * socketChannel适用于通信的channel类型
 */
public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    //添加handler
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        // 通过SocketChannel需获取对应的管道
        ChannelPipeline pipeline = channel.pipeline();

        //将自定义的和netty所提供的handler都添加至pipeline中
        //HttpServerCodec是netty自己提供的助手类，可以理解为拦截器(第一个参数为可以自己命名的助手类名字)
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());

        //添加自定义的助手类，返回"hello netty~"
        pipeline.addLast(":customHandler", new CustomHandler());

    }
}
