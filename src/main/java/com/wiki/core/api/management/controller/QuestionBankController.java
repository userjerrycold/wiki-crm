package com.wiki.core.api.management.controller;

import com.wiki.core.common.reponse.DataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * QuestionBankController
 *
 * @author qian.hu
 * @date 2023/2/9 15:57
 */
@RestController
@RequestMapping("/question_bank")
public class QuestionBankController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/test")
    public DataResponse<Boolean> test(){
        return DataResponse.of(Boolean.TRUE);
    }


}
