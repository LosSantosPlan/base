package com.springboot.Controller;

import com.springboot.Entity.Person;
import com.springboot.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @Autowired
    private PersonServices personServices;

    @GetMapping("/lxb")
    public String pring() {

        return "你好，雷小小小小小小表";
    }

    @GetMapping("/findOne")
    public String findPersonById() {

        return null;
    }
    @GetMapping("/findAll")
    public List<Person> findAll() {
        return  personServices.findAll();

    }
}
