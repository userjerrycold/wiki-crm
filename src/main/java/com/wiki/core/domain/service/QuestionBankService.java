package com.wiki.core.domain.service;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wiki.core.api.management.request.QuestionBankQueryRequest;
import com.wiki.core.api.management.request.QuestionBankSetRequest;
import com.wiki.core.common.exception.DomainException;
import com.wiki.core.common.reponse.DataResponse;
import com.wiki.core.common.reponse.PageDataResponse;
import com.wiki.core.domain.dao.QuestionBankMapper;
import com.wiki.core.domain.listener.ImportExcelListener;
import com.wiki.core.domain.model.dto.QuestionBankDTO;
import com.wiki.core.domain.model.pojo.QuestionBank;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

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

    public PageDataResponse<List<QuestionBankDTO>> getQuestionBank(QuestionBankQueryRequest questionBankQueryRequest){
        Page<QuestionBank> page = new Page<>(questionBankQueryRequest.getPage() + 1L,questionBankQueryRequest.getSize());
        QueryWrapper<QuestionBank> queryWrapper = new QueryWrapper<>();
        IPage<QuestionBank> questionBankPage = questionBankMapper.selectPage(page, queryWrapper);
        return PageDataResponse.of(QuestionBankDTO.of(questionBankPage.getRecords()),page.getCurrent()-1L,page.getSize(),page.getTotal());
    }

    public DataResponse<Boolean> saveSingleQuestion(QuestionBankSetRequest questionBankSetRequest){
        QuestionBank questionBank = QuestionBankSetRequest.of(questionBankSetRequest);
        questionBankMapper.insert(questionBank);
        return DataResponse.of(Boolean.TRUE);
    }

    public DataResponse<Boolean> importQuestion(MultipartFile file){
        try{
            EasyExcel.read(file.getInputStream(),
                    QuestionBank.class,
                    new ImportExcelListener(questionBankMapper)).sheet().headRowNumber(1).doRead();
        }catch (IOException e){
            e.printStackTrace();
            throw new DomainException(e.getMessage());
        }

        return DataResponse.of(Boolean.TRUE);
    }
}
