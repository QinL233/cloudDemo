package com.lqz.user_server.service;

import com.lqz.user_server.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-03-30
 */
public interface SysUserService extends IService<SysUser> {

    List<SysUser> queryAll(SysUser user);

    SysUser queryOne(String id);

}
