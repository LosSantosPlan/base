package com.springboot.Controller;

import com.springboot.Entity.Person;
import com.springboot.Services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @Resource
    private PersonServices personServices;

    @GetMapping("/lxb")
    public String pring() {

        return "你好，雷小小小小小小表";
    }

    @PostMapping("/findOne")
    public String findPersonById() {

        return null;
    }
    @PostMapping("/findAll")
    public List<Person> findAll() {
        return  personServices.findAll();

    }
}
