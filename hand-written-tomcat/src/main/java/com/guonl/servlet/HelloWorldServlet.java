package com.guonl.servlet;

import com.guonl.core.MyRequest;
import com.guonl.core.MyResponse;
import com.guonl.core.MyServlet;

import java.io.IOException;

public class HelloWorldServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {

        try {
            myResponse.write("HelloWorldServlet ---- get method");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {

        try {
            myResponse.write("HelloWorldServlet ---- post method");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
