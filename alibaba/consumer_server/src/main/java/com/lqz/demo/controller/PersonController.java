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

    @GetMapping(value = "/save", produces = "application/x-protobuf")
    public String save(Person entity) {
        if (personService.save(entity)) {
            return "success";
        }
        return "fail";
    }

    @PostMapping(value = "/save2", produces = "application/x-protobuf")
    public String save2(@RequestBody Person entity) {
        if (personService.save(entity)) {
            return "success";
        }
        return "fail";
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @GetMapping("/all")
    public Collection<Person> all() {
        return personService.all();
    }

}
