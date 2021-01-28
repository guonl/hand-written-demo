package com.guonl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/one")
    public String one(){
        return "one";
    }

    @GetMapping("/one2many")
    public String one2many(){
        return "one2many";
    }

    @GetMapping("/one2one")
    public String one2one(){
        return "one2one";
    }


}
