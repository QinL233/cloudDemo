package com.lqz.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lqz.demo.exception.TestServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年07月22日 15:16:00
 */
@Slf4j
@DubboService
public class TestServiceImpl implements TestService {

    @SentinelResource(value = "test1",
            fallback = "test",fallbackClass = {TestServiceException.class})
    @Override
    public String test(Boolean flag) {
        if (flag) {
            throw new RuntimeException("模拟异常");
        }
        return "test";
    }
}
