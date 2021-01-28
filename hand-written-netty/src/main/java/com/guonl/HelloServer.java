package com.guonl;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 功能： 实现客户端发送一个请求，服务器会返回hello netty
 * 参考文章：https://zhuanlan.zhihu.com/p/119453651?utm_source=wechat_timeline
 */
public class HelloServer {


    public static void main(String[] args) throws InterruptedException {

        // 定义一对线程组
        //主线程组 利用NIO的线程组new出来 用于接收客户端的连接，但是不做任何处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //从线程组 让线程组去做相应的任务
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //服务端的启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            //将bossGroup和workerGroup丢进来,在server中设置两个线程组
            //将channel的类型设置为NIO双向通道
            //设置从线程组的助手类处理器，用于处理workGroup
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new HelloServerInitializer());

            //启动server： server绑定端口号,sync方法设置为同步的方式，等待8088端口启动完毕
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();

            //设置关闭对应的的监听 sync设置为同步的方式
            channelFuture.channel().closeFuture().sync();
        } finally {
            //用优雅的方式关闭线程组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }


}
