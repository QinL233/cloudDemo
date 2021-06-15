package com.lqz.demo.service;

import com.lqz.demo.entity.User;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月10日 15:25:00
 */
@DubboService
public class UserServiceImpl implements UserService {

    private final Map<Long, User> map = new ConcurrentHashMap<>();

    @Override
    public boolean save(User entity) {
        map.put(entity.getId(), entity);
        return true;
    }

    @Override
    public boolean save(Map<String, User> entity) {
        System.out.println(entity);
        return false;
    }

    @Override
    public boolean save(List<User> entity) {
        System.out.println(entity);
        return false;
    }

    @Override
    public User getById(Long id) {
        return map.get(id);
    }

    @Override
    public Collection<User> all() {
        return map.values();
    }
}
