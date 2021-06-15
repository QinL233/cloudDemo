package com.lqz.demo.controller;

import com.lqz.demo.entity.User;
import com.lqz.demo.service.UserService;
import com.lqz.demo.util.SerializingUtil;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/save")
    public String save(User entity) {
        byte[] serialize = SerializingUtil.serialize(entity);
        User user = SerializingUtil.deserialize(serialize, User.class);
        if (userService.save(user)) {
            return "success";
        }
        return "fail";
    }

    @PostMapping(value = "/save2")
    public String save2(@RequestBody User entity) {
        byte[] serialize = SerializingUtil.serialize(entity);
        User user = SerializingUtil.deserialize(serialize, User.class);
        if (userService.save(user)) {
            return "success";
        }
        return "fail";
    }

    @PostMapping("/save3")
    public String save3(@RequestBody Map<String, User> entity) {
        if (userService.save(entity)) {
            return "success";
        }
        return "fail";
    }

    @PostMapping("/save4")
    public String save4(@RequestBody List<User> entity) {
        if (userService.save(entity)) {
            return "success";
        }
        return "fail";
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/all")
    public Collection<User> all() {
        return userService.all();
    }
}
