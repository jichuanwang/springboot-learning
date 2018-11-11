package com.dolphin.base;

import lombok.Data;
import lombok.Getter;
import org.junit.Test;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    @Test
    public void test01(){
      /*  RateTypeEnum rateTypeEnum = RateTypeEnum.getRateTypeEnumByCode(222);
        switch (rateTypeEnum) {
            case CHANNEL_FIXED:
            case CHANNEL_LADDER:

                break;
            case STORE_FIXED:

                break;
            case STORE_CATEGORY_LADDER:

                break;
            default:
//                throw new CommissionException("不合法的扣点类型");
        }*/
      Integer a = null;
      if(a == 2){

      }
    }
}
