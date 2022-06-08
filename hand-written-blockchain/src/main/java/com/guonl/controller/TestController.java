package com.guonl.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/event")
    public String testEvent() {
        String data = "这是一个事件";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", data);
        applicationContext.publishEvent(data);
        applicationContext.publishEvent(jsonObject);
        return "success";
    }

}
