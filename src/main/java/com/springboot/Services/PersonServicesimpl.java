package com.springboot.Services;

import com.springboot.Dao.PersonDao;
import com.springboot.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class PersonServicesimpl implements PersonServices{
    @Autowired
    private PersonDao personDao;
    @Override
    public List FindAll() {
        return personDao.FindAll();
    }

    @Override
    public Person FindPersonById(int id) {
        return personDao.FindPersonById(id);
    }
}
