package com.wiki.core.domain.dao;

import com.wiki.core.domain.model.pojo.QuestionBank;
import org.apache.ibatis.annotations.Mapper;

/**
 * QuestionBankMapper
 *
 * @author qian.hu
 * @date 2023/3/7 16:00
 */
@Mapper
public interface QuestionBankMapper {

    QuestionBank findById(Long id);


}
