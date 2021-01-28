package com.guonl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * 此注解表示使用STOMP协议来传输基于消息代理的消息，
 * 此时可以在@Controller类中使用@MessageMapping
 * 参考文章：https://www.cnblogs.com/chbyiming-bky/articles/14218235.html
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketAutoConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                //websocket监听地址，sockjs连接地址（如果有配置项目路径【server.servlet.context-path】，需要加上）
                .addEndpoint("/websocket/web/socket")
                //允许跨域访问
//                .setAllowedOrigins("*")
                //使用sockJS
                .withSockJS();
    }
}
