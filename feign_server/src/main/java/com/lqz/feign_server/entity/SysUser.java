package com.lqz.feign_server.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author liaoQinZhou
 * @since 2021-03-30
 */
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码/加密
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String moblie;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建用户
     */
    private Integer createUser;

    /**
     * 更新用户
     */
    private Integer updateUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 有效时间
     */
    private LocalDateTime validTime;

    /**
     * 有效标志(y/n)
     */
    private String validFlag;

    public Integer getId() {
        return id;
    }

    public SysUser setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SysUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SysUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public SysUser setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getMoblie() {
        return moblie;
    }

    public SysUser setMoblie(String moblie) {
        this.moblie = moblie;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SysUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public SysUser setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public SysUser setCreateUser(Integer createUser) {
        this.createUser = createUser;
        return this;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public SysUser setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public SysUser setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public SysUser setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public LocalDateTime getValidTime() {
        return validTime;
    }

    public SysUser setValidTime(LocalDateTime validTime) {
        this.validTime = validTime;
        return this;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public SysUser setValidFlag(String validFlag) {
        this.validFlag = validFlag;
        return this;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", nickname=" + nickname +
                ", moblie=" + moblie +
                ", email=" + email +
                ", avatar=" + avatar +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", validTime=" + validTime +
                ", validFlag=" + validFlag +
                "}";
    }
}
