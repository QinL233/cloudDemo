package com.lqz.user_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lqz.user_server.entity.SysUser;
import com.lqz.user_server.mapper.SysUserMapper;
import com.lqz.user_server.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-03-30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public List<SysUser> queryAll(SysUser user) {
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        query.setEntity(user);
        List<SysUser> list = this.list(query);
        return list;
    }

    @Override
    public SysUser queryOne(String id) {
        SysUser user = this.getById(id);
        return user;
    }
}
