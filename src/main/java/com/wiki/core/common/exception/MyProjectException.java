package com.wiki.core.common.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * MyGlobalException 全局异常处理
 *
 * @author qian.hu
 * @date 2023/2/22 16:41
 */
@Component
@ControllerAdvice
public class MyProjectException {

    @ExceptionHandler(DomainException.class)
    @ResponseBody
    public Result exception(DomainException e){
        return new Result(e.getCode(),e.getMessage());
    }

}
