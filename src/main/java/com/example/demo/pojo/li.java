package com.example.demo.pojo;

import lombok.Data;

import java.util.Objects;


public class li {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "li{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        li li = (li) o;
        return id == li.id &&
                age == li.age &&
                Objects.equals(name, li.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age);
    }

    public void setAge(int age) {
        this.age = age;

    }

    private int id;
    private String name;
    private int age;
}
