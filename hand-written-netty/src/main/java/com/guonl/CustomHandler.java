package com.guonl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;


/**
 * 功能：创建自定义助手类
 * SimpleChannelInboundHandler： 对于请求来讲，其实相当于[入站，入境]
 */
public class CustomHandler extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, HttpObject msg) throws Exception {


        //获取channel
        Channel channel = ctx.channel();

        if (msg instanceof HttpRequest) {
            //打印显示客户端远程的地址
            System.out.println(channel.remoteAddress());

            //定义发送内容消息(通过缓冲区) 将数据写到缓冲区
            ByteBuf content = Unpooled.copiedBuffer("Hello netty~", CharsetUtil.UTF_8);

            //构建一个HttpResponse 参数：（1）http版本号 (2)状态（例如200，404）(3)相应的内容
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);

            //功能：为响应增加数据类型和长度
            //返回textplain即可，因为是返回字符串
            //返回可读的长度
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            //把response写入缓冲区中并刷到客户端
            ctx.writeAndFlush(response);
        }
    }
}