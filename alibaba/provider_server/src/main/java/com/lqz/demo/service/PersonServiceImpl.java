package com.lqz.demo.service;

import com.lqz.demo.entity.Person;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月16日 09:42:00
 */
@DubboService
public class PersonServiceImpl implements PersonService {

    private final Map<Integer, Person.PersonRequest> map = new ConcurrentHashMap<>();

    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public Person.PersonResponse save(Person.PersonRequest entity) {
        int i = count.getAndIncrement();
        map.put(i, entity);
        Person.PersonResponse.Builder builder = Person.PersonResponse.newBuilder();
        builder.setId(i);
        builder.setUsername(entity.getUsername());
        return builder.build();
    }

    @Override
    public Person.PersonRequest getById(Long id) {
        return map.get(id);
    }

    @Override
    public Collection<Person.PersonRequest> all() {
        return map.values();
    }
}
