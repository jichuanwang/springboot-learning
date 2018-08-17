package com.dolphin.learning.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/8/17 10:57
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String sayHello(){
        return "index";
    }
}
