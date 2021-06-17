package com.lqz.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqz.demo.entity.User;
import com.lqz.demo.mapper.UserMapper;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月10日 15:25:00
 */
@DubboService
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean save(User entity) {
        return saveOrUpdate(entity);
    }

    @Override
    public boolean save(Map<String, User> entity) {
        entity.forEach((k,v)->save(v));
        return true;
    }

    @Override
    public boolean save(List<User> entity) {
        entity.forEach(v->save(v));
        return true;
    }

    @Override
    public User getById(Long id) {
        return getById(id);
    }

    @Override
    public Collection<User> all() {
        return list();
    }
}
