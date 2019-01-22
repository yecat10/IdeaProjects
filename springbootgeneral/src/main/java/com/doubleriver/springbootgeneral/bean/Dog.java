package com.doubleriver.springbootgeneral.bean;

/**
 * @Author ronye
 * @Created 2018/11/16 - 10:56 PM
 */
public class Dog {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private String name;
    private String type;
}
