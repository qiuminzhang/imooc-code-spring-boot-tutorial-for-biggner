package com.programwitherik.restservice.RestApp.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @Entity helps to add annotated class as a table into database.
 */
@Entity
public class Baby {
    @Id
    @GeneratedValue // Auto generated in an ascending order.
    private int id;

    @Min(value = 5, message = "underage")
    private int age;
    private int weight;

    public Baby() {
    }  // Must be non-param, otherwise will raise error

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Baby{" +
                "id=" + id +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
