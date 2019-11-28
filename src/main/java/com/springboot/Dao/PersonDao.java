package com.springboot.Dao;

import com.springboot.Entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public interface PersonDao {
    List findAll();

    Person findPersonById(int id);
}
