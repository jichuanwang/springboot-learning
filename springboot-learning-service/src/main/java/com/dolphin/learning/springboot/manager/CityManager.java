package com.dolphin.learning.springboot.manager;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.dolphin.learning.springboot.entity.City;
import com.dolphin.learning.springboot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author jichuan.wang
 * @since 2018/10/16 16:44
 * <p>
 * </p>
 */
@Service
public class CityManager {

    @Autowired
    private CityMapper cityMapper;

    public int insert(City city){
        city.setCreateTime(new Date());
        city.setUpdateTime(new Date());
        return cityMapper.insert(city);
    }

    public List<City> findList(City city){
        Wrapper<City> wrapper = new EntityWrapper<>(city);
        return cityMapper.selectList(wrapper);
    }

    public List<City> findChildList(){
        Wrapper<City> wrapper = new EntityWrapper<>();
        wrapper.ne("parent_id",0L);
        return cityMapper.selectList(wrapper);
    }

}
