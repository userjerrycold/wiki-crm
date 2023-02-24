package com.wiki.core.common.log.aop;

import com.wiki.core.common.exception.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        // 获取方法名
        String className = pjd.getSignature().getClass().getName();
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
        StringBuilder params = new StringBuilder("前端请求参数为:");
        //获取请求参数集合并进行遍历拼接
        for (Object object : args) {
            params.append(object.toString()).append(",");
        }
        params = new StringBuilder(params.substring(0, params.length() - 1));
        //打印请求参数参数
        log.info(className+"类的"+methodName + "的" + params);
        // 执行目标方法
        result = pjd.proceed();
        // 打印返回报文
        log.info("方法返回报文为:" + (result instanceof Result ? (Result) result : result));
        // 获取执行完的时间
        log.info(methodName + "方法执行时长为:" + (System.currentTimeMillis() - start));
        return result;
    }

    @Before(value = "privilege()")
    public void before(JoinPoint joinPoint) {

    }

    @Before(value = "privilege()")
    public void after(JoinPoint joinPoint) {

    }

    @AfterThrowing(value="privilege()",throwing="ex")
    public void exce(JoinPoint joinPoint, Exception ex) {

    }
}
