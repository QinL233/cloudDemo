package com.lqz.demo.controller;

import com.lqz.demo.entity.Role;
import com.lqz.demo.entity.User;
import com.lqz.demo.service.RoleService;
import com.lqz.demo.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.commons.lang3.RandomUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月17日 17:45:00
 */
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

    @DubboReference
    private UserService userService;

    @DubboReference
    private RoleService roleService;

    /**
     * 多服务分布式回滚操作
     * @return
     */
    @GlobalTransactional
    @GetMapping("/test")
    public String test(){
        //访问服务1
        User user = new User();
        user.setId(RandomUtils.nextInt());
        user.setUsername("test2");
        userService.saveUser(user);
        //访问服务2
        Role role = new Role();
        role.setId(RandomUtils.nextInt());
        role.setName("test");
        roleService.saveRole(role);
        return "success";
    }

    @GetMapping("/all")
    public Collection<Role> all(){
        return roleService.all();
    }
}
