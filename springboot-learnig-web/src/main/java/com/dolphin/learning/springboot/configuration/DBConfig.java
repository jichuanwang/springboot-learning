package com.dolphin.learning.springboot.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Author: kai.zheng
 * Date: 2018/4/13 11:21
 * Description:
 */
@Configuration
@MapperScan("com.dolphin.learning.springboot.mapper")
public class DBConfig {

    /*@Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
*/

}
