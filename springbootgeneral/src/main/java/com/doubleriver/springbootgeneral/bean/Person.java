package com.doubleriver.springbootgeneral.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author ronye
 * @Created 2018/11/16 - 10:57 PM
 */
@PropertySource("classpath:person.properties")
@ConfigurationProperties(prefix = "person")
//从全局配置文件中application.properties或者从application.yml中读取，与@value是两种管理形式
//也可以结合@PropertySource("classpath:person.properties") 与 @ConfigurationProperties(prefix="person")一起使用
@Component//必须将bean登记为组件以便spring容器识别
public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", national='" + national + '\'' +
                ", dog=" + dog +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    private String name;
    /*通过注解注入
    @value("zhangsan")
    private String name;
     */
    private Integer age;
    private Date birthday;
    private String national;
    private Dog dog;
    private List<Object> list;
    private Map<String,Object> map;
}
