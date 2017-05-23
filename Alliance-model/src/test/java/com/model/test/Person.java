package com.model.test;

/**
 * Created by shuyan.qi on 2017/5/18.
 */
public class Person {

    private String name;
    Integer age;
    private Boolean sex;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
