package com.dolphin.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/8/17 10:53
 */

@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
