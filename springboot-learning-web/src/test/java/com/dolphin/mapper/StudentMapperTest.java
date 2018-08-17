package com.dolphin.mapper;

import com.dolphin.BaseTest;
import com.dolphin.learning.springboot.entity.Student;
import com.dolphin.learning.springboot.mapper.StudentMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/8/17 11:14
 */
public class StudentMapperTest extends BaseTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testFind(){
        Student student = studentMapper.selectById(7);
        System.out.println(student);
    }

}
