package com.lqz.demo.service;

import com.lqz.demo.entity.Person;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月16日 09:42:00
 */
@DubboService
public class PersonServiceImpl implements PersonService {
    @Override
    public boolean save(Person entity) {
        return false;
    }

    @Override
    public Person getById(Long id) {
        return null;
    }

    @Override
    public Collection<Person> all() {
        return null;
    }
}
