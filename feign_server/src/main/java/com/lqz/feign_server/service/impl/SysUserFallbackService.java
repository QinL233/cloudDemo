package com.lqz.feign_server.service.impl;

import com.lqz.feign_server.entity.SysUser;
import com.lqz.feign_server.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiaoQinZhou
 * @date: 2021/3/30 18:38
 */
@Service
public class SysUserFallbackService implements SysUserService {
    @Override
    public List<SysUser> list(SysUser entity) {
        return new ArrayList<>();
    }
}
