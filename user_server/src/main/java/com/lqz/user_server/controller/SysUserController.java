package com.lqz.user_server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lqz.user_server.entity.SysUser;
import com.lqz.user_server.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list")
    public List<SysUser> list(@RequestBody(required = false) SysUser entity) {
        return sysUserService.queryAll(entity);
    }

    @GetMapping("/page")
    public IPage<SysUser> page(@RequestParam(value = "current", defaultValue = "1") int current,
                               @RequestParam(value = "size", defaultValue = "10") int size,
                               @RequestBody(required = false) SysUser entity) {
        IPage<SysUser> page = new Page<>(current, size);
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.setEntity(entity);
        return sysUserService.page(page, wrapper);
    }
}
