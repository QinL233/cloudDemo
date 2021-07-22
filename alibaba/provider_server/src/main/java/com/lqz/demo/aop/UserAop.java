package com.lqz.demo.aop;

import com.lqz.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月22日 13:35:00
 */
@Aspect
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Order(1)
@Slf4j
public class UserAop {

    @Pointcut("execution(public * com.lqz.demo.service.UserService.saveUser(..))")
    public void saveUser() {
    }


    @Around("saveUser()")
    public Object doLoginIntegral(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed(joinPoint.getArgs());
        if (Objects.nonNull(result)) {
            log.info("success");
        }
        return result;
    }
}