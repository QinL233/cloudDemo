package com.lqz.feign_server.controller;

import com.lqz.feign_server.entity.SysUser;
import com.lqz.feign_server.service.SysUserService;
import com.lqz.feign_server.vo.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/30 17:12
 */
@RestController
public class TestController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/test")
    public ResultResponse test(@RequestBody(required = false) SysUser user) {
        List<SysUser> list = sysUserService.list(user);
        return new ResultResponse(list);
    }
}
