package com.springboot.Services;

import com.springboot.Entity.Person;

import java.io.IOException;
import java.util.List;

public interface PersonServices {
    String FindAll();
    Person FindPersonById(int id);
}
