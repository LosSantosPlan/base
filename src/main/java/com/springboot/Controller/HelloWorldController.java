package com.springboot.Controller;

import com.springboot.Entity.Person;
import com.springboot.Services.PersonServices;
import com.springboot.Utils.ExcelUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author sheep
 */

@Controller
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
    @ApiOperation(value = "查询",notes = "查询所有Person，返回一个modelmap")
    @GetMapping("/findAll")
    @ResponseBody
    public List findAll(ModelMap map) {
        List<Person>list=personServices.findAll();
        map.addAttribute("list",list);
        return list;
    }
    @ApiOperation(value = "插入list",notes = "插入list中所有Person对象")
    @GetMapping("/insert")
    public String insertPersonList(){
        Person p=new Person("小白",18,1800);
        Person p2=new Person("小黑",19,1900);
        List<Person> list =new ArrayList<>();
        list.add(p);
        list.add(p2);
        personServices.insertPersonList(list);
        return "插入成功";
    }
    @ApiOperation(value = "待实现")
    @GetMapping("/update")
    public String updatePersonList(){
        Person p=new Person("孟全",18,2800);
        Person p2=new Person("刘义龙",19,2900);
        List<Person> updateList =new ArrayList<>();
        updateList.add(p);
        updateList.add(p2);
        personServices.updatePersonList(updateList);
        return "修改成功";
    }
    @ApiOperation(value = "接收前端传值")
    @RequestMapping(value = "testConnect",method =RequestMethod.GET)
    @ResponseBody
    public String testConnect(@RequestParam("name") String name){
        System.out.println(name);
        return name;
    }

    @RequestMapping("/show")
    public String retunIndex(){
        return "show";
    }

    ExcelUtils excelUtils=new ExcelUtils();

    @ApiOperation(value = "Excel解析")
    @PostMapping("/upload")
    @ResponseBody
    public String getExcel(HttpServletRequest request) throws Exception{
        MultipartHttpServletRequest multipartrequest= (MultipartHttpServletRequest) request;
        MultipartFile file =multipartrequest.getFile("filename");
        if (file.isEmpty()){
            return "文件不能为空";
        }
        InputStream inputStream=file.getInputStream();
        List<List<Object>> list = excelUtils.analyzeExcel(inputStream, file.getOriginalFilename());
        inputStream.close();
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            //TODO 随意发挥
            System.out.println(lo);

        }
         return "上传成功";
    }
}
