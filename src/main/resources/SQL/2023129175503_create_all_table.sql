use wiki;

drop table wikis;

CREATE TABLE `wikis`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `topic`     varchar(64) NOT NULL COMMENT '主题',
    `topic_type`   tinyint(4) NOT NULL COMMENT '主题类型：0学习 1游戏 2电影 3机车 4新闻 5其他',
    `title`            varchar(64)  DEFAULT NULL COMMENT '标题',
    `author`        varchar(64)  DEFAULT NULL COMMENT '作者',
    `recommend`     bigint(20)   DEFAULT NULL COMMENT '推荐指数',
    `content`         text         DEFAULT NULL COMMENT '其余内容',
    `comment`         text  DEFAULT NULL COMMENT '评论',
    `status`          tinyint(4) NOT NULL COMMENT '状态：0启用中 1停用中',
    `operator_id`     bigint(20) NOT NULL comment '最后修改人id',
    `operator_name`   varchar(64) NOT NULL comment '最后修改人姓名',
    `create_dt`      datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_dt`      datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='wiki';


drop table schedules;

CREATE TABLE `schedules`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `type`           tinyint(4) NOT NULL COMMENT '类型：0每日 1自定义',
    `content`           varchar(256)  DEFAULT NULL COMMENT '内容',
    `author`        varchar(64)  DEFAULT NULL COMMENT '作者',
    `order`         int(11)   DEFAULT NULL COMMENT '顺序',
    `comment`         text  DEFAULT NULL COMMENT '备注',
    `status`          tinyint(4) NOT NULL COMMENT '状态：0待办 1已完成',
    `create_dt`      datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_dt`      datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='待办事宜表';

drop table question_bank;

CREATE TABLE `question_bank`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `is_java`           tinyint(1) NOT NULL COMMENT '判断是否是java类型',
    `type`           tinyint(4)  DEFAULT NULL COMMENT '0JVM 1JMM 2JUC 3集合 4IO 5多线程 6mysql 7spring 8spring MVC 9spring boot 10 spring cloud 11DDD 12Mybatis 13redis 14dubbo 15zookeeper 16网络/IO 17k8s 18linux 19maven 20git',
    `author`        varchar(64)  DEFAULT NULL COMMENT '作者',
    `order`         int(11)   DEFAULT NULL COMMENT '顺序',
    `title`         varchar(64)  DEFAULT NULL COMMENT '题目',
    `level`         tinyint(4)  DEFAULT NULL COMMENT '难度等级：0星 1星 2星 3星 4星 5星',
    `hint`          varchar(64) NOT NULL COMMENT '简短的提示信息',
    `answer`          text  DEFAULT NULL COMMENT '标准答案',
    `create_dt`      datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_dt`      datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='智能题库';

drop table question_statistics;

CREATE TABLE `question_statistics`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `question_id`           bigint(20) NOT NULL COMMENT '题目编号',
    `times`           int(11)  DEFAULT NULL COMMENT '答题人刷到的次数',
    `operator_id`        bigint(20)  NOT NULL COMMENT '答题人id',
    `score`         int(11)   NOT NULL COMMENT '答题人自己最近一次评分',
    `comment`         text  DEFAULT NULL COMMENT '答题人备注',
    `create_dt`      datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_dt`      datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='题目统计';

drop table recommend_questions;

CREATE TABLE `recommend_questions`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `is_java`           tinyint(1) NOT NULL COMMENT '判断是否是java类型',
    `type`           tinyint(4)  DEFAULT NULL COMMENT '0JVM 1JMM 2JUC 3集合 4IO 5多线程 6mysql 7spring 8spring MVC 9spring boot 10 spring cloud 11DDD 12Mybatis 13redis 14dubbo 15zookeeper 16网络/IO 17k8s 18linux 19maven 20git',
    `author`        varchar(64)  DEFAULT NULL COMMENT '作者',
    `order`         int(11)   DEFAULT NULL COMMENT '顺序',
    `title`         varchar(64)  DEFAULT NULL COMMENT '题目',
    `level`         tinyint(4)  DEFAULT NULL COMMENT '难度等级：0星 1星 2星 3星 4星 5星',
    `hint`          varchar(64) NOT NULL COMMENT '简短的提示信息',
    `answer`          text  DEFAULT NULL COMMENT '标准答案',
    `create_dt`      datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_dt`      datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='每日推荐题库';