package com.wiki.core.api.management.controller;

import com.wiki.core.api.management.request.QuestionBankQueryRequest;
import com.wiki.core.api.management.request.QuestionBankSetRequest;
import com.wiki.core.common.reponse.DataResponse;
import com.wiki.core.common.reponse.PageDataResponse;
import com.wiki.core.domain.model.dto.QuestionBankDTO;
import com.wiki.core.domain.service.QuestionBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * QuestionBankController
 *
 * @author qian.hu
 * @date 2023/2/9 15:57
 */
@Api(value = "API - QuestionBankController",description = "题目信息API")
@RestController
@RequestMapping("/question_bank")
public class QuestionBankController {

    @Resource
    private QuestionBankService questionBankService;

    @ApiOperation(value = "根据条件查询满足条件的题库信息")
    @PostMapping
    public PageDataResponse<List<QuestionBankDTO>> getAllQuestionBank(@Valid @RequestBody QuestionBankQueryRequest questionBankQueryRequest){
        return questionBankService.getQuestionBank(questionBankQueryRequest);
    }

    @ApiOperation(value = "根据管理页面单条配置")
    @PostMapping("/question/save")
    public DataResponse<Boolean> setQuestion(@RequestBody QuestionBankSetRequest questionBankSetRequest){
        return questionBankService.saveSingleQuestion(questionBankSetRequest);
    }

    @ApiOperation(value = "根据excel导入题库")
    @PostMapping("/import")
    public DataResponse<Boolean> importQuestionBank(@RequestParam("file") MultipartFile file){
        return questionBankService.importQuestion(file);
    }

}
