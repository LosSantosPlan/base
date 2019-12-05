package com.springboot.Dao;

import com.springboot.Entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @author 23696
 */
@Repository
public interface PersonDao {
   /**
    *查找所有Person
    */
    List<Person> findAll();

    /**
     * @param id
     * @return
     */
    Person findPersonById(int id);

    /**
     * @param list
     * 批处理插入
     */
    void insertPersonList(List<Person> list);

    void updatePersonList(List<Person> list);


}
