package com.dolphin.learning.springboot.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by wangjichuan on 2018/9/21.
 */
@Document(indexName = "blog", type = "article")
@Data
public class Article {

    private Long id;

    private String name;
}

