package com.dolphin.learning.springboot.controller;

import com.dolphin.learning.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/8/17 10:57
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String sayHello(){
        String name = studentService.getName();
        System.out.println(name);
        System.out.println(Thread.currentThread().getName());
        return "index";
    }
}
