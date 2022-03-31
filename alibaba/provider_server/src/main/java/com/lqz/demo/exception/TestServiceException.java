package com.lqz.demo.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月22日 15:48:00
 */
@Slf4j
public class TestServiceException {


    public static String test(Boolean flag, Throwable e) {
        if (e instanceof RuntimeException) {
            log.error(e.getMessage());
        }
        return "Error";
    }
}
