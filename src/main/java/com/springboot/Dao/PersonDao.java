package com.springboot.Dao;

import com.springboot.Entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Mapper
public interface PersonDao {
    String FindAll();
    Person FindPersonById(int id);
}
