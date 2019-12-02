package com.springboot.Controller;

import com.springboot.Entity.Person;
import com.springboot.Services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sheep
 */

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @Resource
    private PersonServices personServices;
    @ApiOperation(value = "问好")
    @GetMapping("/lxb")
    public String pring() {

        return "你好，雷小小小小小小表";
    }
    @ApiOperation(value = "待实现")
    @PostMapping("/findOne")
    public String findPersonById() {

        return null;
    }
    @ApiOperation(value = "查询",notes = "查询所有Person")
    @GetMapping("/findAll")
    public List<Person> findAll() {
        return  personServices.findAll();

    }

    @GetMapping("/insert")
    public String insertPersonList(){
        Person p=new Person("小白",18,1800);
        Person p2=new Person("小黑",19,1900);
        List<Person> list =new ArrayList<>();
        list.add(p);
        list.add(p2);
        personServices.insertPersonList(list);
        return null;
    }
}
