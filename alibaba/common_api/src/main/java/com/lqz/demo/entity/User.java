package com.lqz.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月10日 14:37:00
 */
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 474447092288987532L;

    private Integer id;

    private String username;

    private String password;
}
