package com.wiki.core.domain.model.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wiki.core.common.enums.NamedEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * QuestionBank
 *
 * @author qian.hu
 * @date 2023/3/7 10:28
 */
@Data
@TableName("question_bank")
public class QuestionBank {

    @ExcelIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 判断是否是java类型
     */
    @ExcelProperty("是否是JAVA")
    private Boolean isJava;

    /**
     * 0JVM 1JMM 2JUC 3集合 4IO 5多线程 6mysql 7spring 8spring MVC
     * 9spring boot 10 spring cloud 11DDD 12Mybatis 13redis 14dubbo
     * 15zookeeper 16网络/IO 17k8s 18linux 19maven 20git
     */
    @ExcelProperty("题目类型")
    private Integer type;

    /**
     * 作者
     */
    @ExcelProperty("作者")
    private String author;

    /**
     * 顺序
     */
    @ExcelProperty("顺序")
    private Integer qOrder;

    /**
     * 题目
     */
    @ExcelProperty("题目")
    private String title;

    /**
     * 难度等级：0星 1星 2星 3星 4星 5星
     */
    @ExcelProperty("难度等级")
    private Byte level;

    /**
     * 简短的提示信息
     */
    @ExcelProperty("提示")
    private String hint;

    /**
     * 标准答案
     */
    @ExcelProperty("标准答案")
    private String answer;

    @ExcelIgnore
    private Date createDt;

    @ExcelIgnore
    private Date updateDt;

    @Getter
    @AllArgsConstructor
    public enum QuestionType implements NamedEnum {
        JVM(0,"JVM"),
        JMM(1,"JMM"),
        JUC(2,"JUC"),
        COLLECT(3,"集合"),
        THREAD(4,"多线程"),
        MYSQL(5,"Mysql"),
        SPRING(6,"Spring"),
        SPRING_MVC(7,"Spring MVC"),
        SPRING_BOOT(8,"Spring Boot"),
        SPRING_CLOUD(9,"Spring Cloud"),
        MYBATIS(10,"Mybatis"),
        REDIS(11,"Redis"),
        IO(12,"网络IO"),
        K8S(13,"k8s"),
        LINUX(14,"Linux"),
        MAVEN(15,"Maven"),
        GIT(16,"Git");

        private final Integer code;
        private final String name;

        public static QuestionType getEnumByKey(Integer code) {
            if (null == code) {
                return null;
            }
            for (QuestionType temp : QuestionType.values()) {
                if (Objects.equals(temp.getCode(), code)) {
                    return temp;
                }
            }
            return null;
        }

        private static final Map<Integer, String> map = new HashMap<>();

        static {
            for (QuestionType tEnum : QuestionType.values()) {
                map.put(tEnum.getCode(), tEnum.getName());
            }
        }

    }

    public void setType(QuestionType questionType){
        this.type = questionType.code;
    }

    public QuestionType getType(){
        return QuestionType.getEnumByKey(this.type);
    }

}
