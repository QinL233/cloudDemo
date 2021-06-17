package com.lqz.demo.service;


import com.lqz.demo.entity.Person;

import java.util.Collection;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月16日 09:41:00
 */
public interface PersonService {

    Person.PersonResponse save(Person.PersonRequest entity);

    Collection<Person.PersonRequest> all();
}
