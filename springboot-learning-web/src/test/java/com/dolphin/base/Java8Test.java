package com.dolphin.base;

import lombok.Data;
import lombok.Getter;
import org.junit.Test;
import java.util.Hashtable;

import javax.jnlp.IntegrationService;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;

/**
 * Created by wangjichuan on 2018/8/19.
 */
public class Java8Test {

    @Test
    public void test(){

        List<Integer> myList = new ArrayList<>();
        myList.add(12);
        myList.add(11223);


        myList.stream().forEach(System.out::println);

        int num = 2;
        Function<Integer,Integer> stringConvert = (from) -> from*num;
        System.out.println(stringConvert.apply(4));

    }
    @Getter
    enum RateTypeEnum {

        CHANNEL_FIXED(1, "渠道固定扣点", 1),
        CHANNEL_LADDER(2, "渠道阶梯扣点", 2),
        STORE_FIXED(3, "门店固定扣点", 3),
        STORE_CATEGORY_LADDER(4, "门店类目阶梯扣点", 4);
        private Integer code;
        private String name;
        private Integer outCode;

        RateTypeEnum(Integer code, String name, Integer outCode) {
            this.code = code;
            this.name = name;
            this.outCode = outCode;
        }

        public static RateTypeEnum getRateTypeEnumByCode(Integer code) {
            for (RateTypeEnum goodsFeeStatsStatus : RateTypeEnum.values()) {
                if (goodsFeeStatsStatus.code.equals(code))
                    return goodsFeeStatsStatus;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        System.out.println(111);
        map.put(null,null);
        map.put(null,null);
        map.put(null,null);
        map.put(null,null);
        map.put(null,null);
        map.put(1,null);
        map.put(2,null);
        System.out.println(map.entrySet());

        Map map1 = new Hashtable<>();
        map1.put(null,1);
        map1.put(2,null);
        System.out.println(map1.size());
    }

    @Test
    public void test01(){

    }
}
