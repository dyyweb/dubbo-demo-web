package com.dy.entity;

import java.io.Serializable;

/**
 * @author: dy
 * @date: 2017.2.24
 */
public class User implements Serializable {
    private String userName;
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
