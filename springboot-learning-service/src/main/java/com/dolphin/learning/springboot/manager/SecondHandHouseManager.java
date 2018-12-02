package com.dolphin.learning.springboot.manager;

import com.dolphin.learning.springboot.entity.City;
import com.dolphin.learning.springboot.entity.SecondHandHouse;
import com.dolphin.learning.springboot.mapper.CityMapper;
import com.dolphin.learning.springboot.mapper.SecondHandHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author jichuan.wang
 * @since 2018/10/16 16:44
 * <p>
 * </p>
 */
@Service
public class SecondHandHouseManager {

    @Autowired
    private SecondHandHouseMapper secondHandHouseMapper;

    public int insert(SecondHandHouse secondHandHouse){
        secondHandHouse.setCreateTime(new Date());
        secondHandHouse.setUpdateTime(new Date());
        return secondHandHouseMapper.insert(secondHandHouse);
    }
}
