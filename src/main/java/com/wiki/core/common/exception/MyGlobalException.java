package com.wiki.core.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MyGlobalException 全局异常处理
 *
 * @author qian.hu
 * @date 2023/2/22 16:41
 */
@Slf4j
@Component
@ControllerAdvice
public class MyGlobalException {

    @ExceptionHandler(DomainException.class)
    @ResponseBody
    public Result domainException(DomainException e){
        log.info(String.format("业务发现异常: code %s  massage %s", e.getCode(),e.getMessage()));
        return new Result(e.getCode(),e.getMessage());
    }



    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(HttpServletRequest request,
                            HttpServletResponse response,
                            Exception exception) {
        log.error("服务器异常",exception);
        return new Result(500,exception.getMessage());
    }
}
