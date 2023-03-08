package com.wiki.core.domain.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

/**
 * QuestionBank
 *
 * @author qian.hu
 * @date 2023/3/7 10:28
 */
@Data
public class QuestionBank {

    private Long id;

    /**
     * 判断是否是java类型
     */
    private Boolean isJava;

    /**
     * 0JVM 1JMM 2JUC 3集合 4IO 5多线程 6mysql 7spring 8spring MVC
     * 9spring boot 10 spring cloud 11DDD 12Mybatis 13redis 14dubbo
     * 15zookeeper 16网络/IO 17k8s 18linux 19maven 20git
     */
    private Byte type;

    /**
     * 作者
     */
    private String author;

    /**
     * 顺序
     */
    private Integer order;

    /**
     * 题目
     */
    private String title;

    /**
     * 难度等级：0星 1星 2星 3星 4星 5星
     */
    private Byte level;

    /**
     * 简短的提示信息
     */
    private String hint;

    /**
     * 标准答案
     */
    private String answer;

    private Date createDt;

    private Date updateDt;

}
