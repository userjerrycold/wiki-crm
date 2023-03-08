package com.wiki.core.domain.service;

import com.wiki.core.domain.dao.QuestionBankMapper;
import com.wiki.core.domain.model.dto.QuestionBankDTO;
import com.wiki.core.domain.model.pojo.QuestionBank;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * QuestionBankService
 *
 * @author qian.hu
 * @date 2023/3/7 16:02
 */
@Service
public class QuestionBankService {

    @Resource
    private QuestionBankMapper questionBankMapper;

    public QuestionBankDTO findById(Long id){
        QuestionBank questionBank = questionBankMapper.findById(id);
        return QuestionBankDTO.of(questionBank);
    }


}
