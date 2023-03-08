package com.wiki.core.common.log.aop;

import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.binding.StringFormatter;
import com.wiki.core.common.exception.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ControllerAop
 * 功能描述 :用于controller层操作的AOP类
 * 其中@Aspect 注解代表其为一个切面管理类,可以在其下定义切入点表达式，aspectJ框架会进行解析。
 * @author qian.hu
 * @date 2023/2/22 17:49
 */
@Component
@Aspect // 代表此类为一个切面类
public class ControllerAop {

    @Pointcut("execution(public * com.wiki.core.api.*.controller..*.*(..))") // 切入点表达式
    public void privilege() {

    }

    @Around("privilege()")
    public Object around(ProceedingJoinPoint pjd) throws Throwable {
        // 获取类全限定名
        String className = pjd.getSignature().getDeclaringTypeName();
        // 获取执行的方法名称
        String methodName = pjd.getSignature().getName();
        /** 初始化日志打印 */
        Logger log = LoggerFactory.getLogger(className);
        // 定义返回参数
        Object result = null;
        // 记录开始时间
        long start = System.currentTimeMillis();
        // 获取方法参数
        Object[] args = pjd.getArgs();
        List<String> params = new ArrayList<>(args.length);
        String paramStr = "" ;
        if(!ObjectUtils.isEmpty(args)){
            for (Object arg : args) {
                params.add(JSONObject.toJSONString(arg));
            }
            paramStr = String.join(",",params);
        }
        result = pjd.proceed();

        Object resultObject = result instanceof Result ? result : result;

        log.info(String.format("%n Class:  %s %n Method: %s  %n Request: %s %n Response: %s %n Take time: %sms",className,methodName,paramStr,JSONObject.toJSON(resultObject).toString(), (System.currentTimeMillis() - start)));
        return result;
    }

    @Before(value = "privilege()")
    public void before(JoinPoint joinPoint) {

    }

    @Before(value = "privilege()")
    public void after(JoinPoint joinPoint) {

    }

    @AfterThrowing(value="privilege()",throwing="ex")
    public void exec(JoinPoint joinPoint, Exception ex) {

    }
}
