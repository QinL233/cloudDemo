package com.lqz.feign_server.service;

import com.lqz.feign_server.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-03-30
 */
@FeignClient(value = "user-service")
public interface SysUserService {

    /**
     * get 请求参数必须全部为@RequestParam修饰
     * post无或有且仅有一个@RequestBody修饰，其它参数必须为@RequestParam修饰
     *
     * @param entity
     * @return
     */
    @GetMapping("/sysUser/list")
    List<SysUser> list(@RequestParam(name="entity",required = false) SysUser entity);

}
