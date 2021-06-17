package com.lqz.demo.controller;

import com.lqz.demo.entity.Person;
import com.lqz.demo.service.PersonService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月16日 09:42:00
 */
@RestController
@CrossOrigin
@RequestMapping("/person")
public class PersonController {

    @DubboReference
    private PersonService personService;

    @PostMapping(value = "/save")
    public Person.PersonResponse save(@RequestBody Person.PersonRequest entity) {
        Person.PersonResponse personResponse = personService.save(entity);
        return personResponse;
    }

    @GetMapping("/all")
    public Collection<Person.PersonRequest> all() {
        return personService.all();
    }

}
