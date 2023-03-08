package com.wiki.core.api.management.controller;

import com.wiki.core.api.management.request.QuestionBankQueryRequest;
import com.wiki.core.common.reponse.DataResponse;
import com.wiki.core.common.reponse.PageDataResponse;
import com.wiki.core.domain.model.dto.QuestionBankDTO;
import com.wiki.core.domain.service.QuestionBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * QuestionBankController
 *
 * @author qian.hu
 * @date 2023/2/9 15:57
 */
@Api(value = "QuestionBankController 题库")
@RestController
@RequestMapping("/question_bank")
public class QuestionBankController {

    @Resource
    private QuestionBankService questionBankService;


    @ApiOperation(value = "根据ID查询题目信息")
    @GetMapping("/{id}")
    public DataResponse<QuestionBankDTO> findById(@PathVariable("id") Long id){
        return DataResponse.of(questionBankService.findById(id));
    }

    @ApiOperation(value = "查询所有题目信息")
    @PostMapping
    public PageDataResponse<QuestionBankDTO> getAllQuestionBank(@RequestBody QuestionBankQueryRequest questionBankQueryRequest){
        return PageDataResponse.of(new QuestionBankDTO(),0,1,1);
    }



}
