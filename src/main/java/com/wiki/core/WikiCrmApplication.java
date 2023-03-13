package com.wiki.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * com.wiki.core.WikiCrmApplication
 *
 * @author qian.hu
 * @date 2023/1/29 16:13
 */
@SpringBootApplication
@MapperScan("com.wiki.core.domain.dao")
public class WikiCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(WikiCrmApplication.class);
    }
}
