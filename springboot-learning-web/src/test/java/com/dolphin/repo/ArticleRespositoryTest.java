package com.dolphin.repo;

import com.dolphin.BaseTest;
import com.dolphin.learning.springboot.entity.Article;
import com.dolphin.learning.springboot.repo.ArticleRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Created by wangjichuan on 2018/9/21.
 */
public class ArticleRespositoryTest extends BaseTest {

    private ArticleRepository articleRepository;

/*    *//**
     * 查询
     *//*
    @Test
    public void test(){
        Optional<Article> article = articleRepository.findById(1L);
        System.out.println(article);
    }*/
}
