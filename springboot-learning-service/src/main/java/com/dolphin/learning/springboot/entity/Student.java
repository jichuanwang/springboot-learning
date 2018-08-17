package com.dolphin.learning.springboot.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/8/17 11:01
 */
@TableName("student")
@Data
public class Student {

    private Long id;
    private String name;
    private int age;
    private String address;
}
