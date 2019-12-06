package com.springboot;

import com.springboot.Entity.Person;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 23696
 */
@SpringBootApplication
@MapperScan("com.springboot.Dao")
public class BaseApplication {



    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);

    }

}
