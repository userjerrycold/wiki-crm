package com.wiki.core.domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wiki.core.domain.model.pojo.QuestionBank;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * QuestionBankMapper
 *
 * @author qian.hu
 * @date 2023/3/7 16:00
 */
public interface QuestionBankMapper extends BaseMapper<QuestionBank> {

    @Insert("<script>" +
            "insert into question_bank(is_java,type,author,q_order,title,level,hint,answer) values" +
            "<foreach collection='questionBankList' index='index' item='item' separator=','>" +
            "(#{item.isJava},#{item.type},#{item.author},#{item.qOrder},#{item.title},#{item.level},#{item.hint},#{item.answer})" +
            "</foreach>" +
            "</script>")
    int batchInsertData(List<QuestionBank> questionBankList);

}
