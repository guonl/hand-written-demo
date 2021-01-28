package com.guonl.servlet;

import com.guonl.core.ServletMapping;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    //制定哪个URL交给哪个servlet来处理
    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "com.guonl.servlet.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld", "/world", "com.guonl.servlet.HelloWorldServlet"));
    }


}
