package com.wiki.core.api.management.request;

import com.wiki.core.domain.model.pojo.QuestionBank;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * QuestionBankSetRequest
 *
 * @author qian.hu
 * @date 2023/3/8 17:38
 */
@Data
@ApiModel("QuestionBankSetRequest")
public class QuestionBankSetRequest {

    @ApiModelProperty("判断是否是java类型")
    private Boolean isJava;

    @ApiModelProperty("      0JVM 1JMM 2JUC 3集合 4IO 5多线程 6mysql 7spring 8spring MVC\n" +
            "      9spring boot 10 spring cloud 11DDD 12Mybatis 13redis 14dubbo\n" +
            "      15zookeeper 16网络/IO 17k8s 18linux 19maven 20git")
    private Byte type;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("顺序")
    private Integer qOrder;

    @ApiModelProperty("题目")
    private String title;

    @ApiModelProperty("标准答案")
    private String answer;

    @ApiModelProperty("难度等级：0星 1星 2星 3星 4星 5星")
    private Byte level;


    public static QuestionBank of(QuestionBankSetRequest questionBankSetRequest){
        QuestionBank questionBank = new QuestionBank();
        BeanUtils.copyProperties(questionBankSetRequest,questionBank);
        return questionBank;
    }
}
