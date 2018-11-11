package com.dolphin.learning.springboot.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author jichuan.wang
 * @since 2018/10/16 15:55
 * <p>
 * </p>
 */
@Data
@TableName("city")
public class City {
    private Long id;
    private String name;
    private Long parentId;
    private String shortCode;
    private Date createTime;
    private Date updateTime;

}
