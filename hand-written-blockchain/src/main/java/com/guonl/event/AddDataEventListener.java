package com.guonl.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AddDataEventListener {

    /**
     * 在AnnotationConfigUtils#registerAnnotationConfigProcessors
     * 注册了BeanDefinition 对应的是EventListenerMethodProcessor对象，
     * AnnotationConfigUtils在AnnotationConfigServletWebServerApplicationContext构造方法里被加载
     */

    /**
     * DefaultListableBeanFactory#中preInstantiateSingletons -> (beanName为org.springframework.context.event.internalEventListenerProcessor时得到EventListenerMethodProcessor)EventListenerMethodProcessor#afterSingletonsInstantiated this.processBean(factories, beanName, type)
     * 然后把要执行的方法封装为ApplicationListenerMethodAdapter -> 添加到listener中 AbstractApplicationEventMulticaster#addApplicationListener
     */
    @EventListener
    public void handleAddEvent(String event) {
        log.info("发布的data为:{}  ", event);
    }

    @EventListener
    public void handleJsonEvent(JSONObject event) {
        log.info("发布的json为:{}  ", JSON.toJSONString(event));
    }


    @EventListener
    public void handleJson2Event(JSONObject event) {
        log.info("发布的json2为:{}  ", JSON.toJSONString(event));
    }


}
