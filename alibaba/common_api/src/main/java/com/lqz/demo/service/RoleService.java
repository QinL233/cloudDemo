package com.lqz.demo.service;

import com.lqz.demo.entity.Role;

import java.util.Collection;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月10日 17:37:00
 */
public interface RoleService {

    boolean saveRole(Role entity);

    Collection<Role> all();
}
