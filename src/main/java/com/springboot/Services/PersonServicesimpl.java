package com.springboot.Services;

import com.springboot.Dao.PersonDao;
import com.springboot.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * service实现类
 */
@Service
public class PersonServicesimpl implements PersonServices {
    @Resource
    private PersonDao personDao;

    @Override
    public List findAll() {
        return personDao.findAll();
    }

    @Override
    public Person findPersonById(int id) {
        return personDao.findPersonById(id);
    }

    @Override
    public void insertPersonList(List<Person> list) {
        personDao.insertPersonList(list);
    }
}
