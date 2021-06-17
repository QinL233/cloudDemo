package com.lqz.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqz.demo.entity.Role;
import com.lqz.demo.mapper.RoleMapper;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月17日 17:41:00
 */
@DubboService
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public boolean saveRole(Role entity) {
        return saveOrUpdate(entity);
    }

    @Override
    public Collection<Role> all() {
        return list();
    }
}
