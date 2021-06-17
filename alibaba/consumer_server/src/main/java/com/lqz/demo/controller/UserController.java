package com.lqz.demo.controller;

import com.lqz.demo.entity.User;
import com.lqz.demo.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月10日 15:32:00
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @DubboReference
    private UserService userService;

    @GetMapping(value = "/save")
    public String save(User entity) {
        if (userService.saveUser(entity)) {
            return "success";
        }
        return "fail";
    }

    @PostMapping(value = "/save2")
    public String save2(@RequestBody User entity) {
        if (userService.saveUser(entity)) {
            return "success";
        }
        return "fail";
    }

    @GetMapping("/all")
    public Collection<User> all() {
        return userService.all();
    }

}
