package com.dolphin.learning.springboot.service.impl;

import com.dolphin.learning.springboot.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jichuan.wang
 * @<p>:
 * @since 2018/9/11 09:52
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    @Transactional
    public String getName() {
        return "wjc";
    }
}
