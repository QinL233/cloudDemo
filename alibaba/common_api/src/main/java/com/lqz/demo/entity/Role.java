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
 * @createTime 2021年06月10日 17:36:00
 */
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Data
public class Role implements Serializable{

    private static final long serialVersionUID = 589469880986789329L;

    private Long id;

    private String name;
}
