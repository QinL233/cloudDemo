package com.lqz.user_server.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/5 17:28
 */
@Aspect
@Component
@Order(1)
public class WebLogAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAop.class);

    /**
     * 表达式指向切入点
     */
    @Pointcut("execution(public * com.lqz.user_server.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * 方法前
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        LOGGER.info("before");
    }

    /**
     * 方法后
     *
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
        LOGGER.info("after");
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("around");
        return joinPoint.proceed();
    }

}
