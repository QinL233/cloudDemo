package com.lqz.demo.entity;

import java.io.Serializable;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月10日 17:36:00
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 2075061073555158858L;
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
