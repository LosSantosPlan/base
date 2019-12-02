package com.springboot.Services;

import com.springboot.Entity.Person;

import java.io.IOException;
import java.util.List;

public interface PersonServices {
    /**
     * 查找所有Person
     * @return
     */
    List<Person> findAll();

    /**
     * 根据id查找Person
     * @param id
     * @return
     */
    Person findPersonById(int id);

    /**
     * 批量插入
     *
     * */
    void insertPersonList(List<Person> list);
}
