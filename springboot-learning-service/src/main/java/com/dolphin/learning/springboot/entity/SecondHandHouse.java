package com.dolphin.learning.springboot.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jichuan.wang
 * @since 2018/10/16 15:55
 * <p>
 * </p>
 */
@Data
@TableName("second_hand_house")
public class SecondHandHouse {
    private Long id;
    /**
     * 小区名称
     */
    private String communityName;
    /**
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 户型
     */
    private String houseType;
    /**
     * 面积
     */
    private String area;
    /**
     * 朝向
     */
    private String orientations;
    /**
     * 装修情况
     */
    private String fitment;
    /**
     * 城市id
     */
    private Long cityId;
    private Date createTime;
    private Date updateTime;

}
