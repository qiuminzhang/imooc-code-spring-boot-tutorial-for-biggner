package com.programwitherik.restservice.RestApp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Component // Helps with conduct configuration
// ⬇️use person configuration in the application-dev/prod.yml files
@ConfigurationProperties(prefix = "person")
public class Person {
    private int id;
    private int height;
    private int age;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @RequestMapping("/map")
    public int height() {
        return this.getHeight();
    }
}
