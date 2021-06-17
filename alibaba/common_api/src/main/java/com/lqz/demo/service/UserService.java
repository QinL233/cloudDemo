package com.lqz.demo.service;

import com.lqz.demo.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月10日 14:40:00
 */
public interface UserService {

    boolean saveUser(User entity);

    User getById(Long id);

    Collection<User> all();
}
