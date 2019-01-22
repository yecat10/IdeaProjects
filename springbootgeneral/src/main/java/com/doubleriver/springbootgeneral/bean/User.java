package com.doubleriver.springbootgeneral.bean;

import javax.persistence.*;

/**
 * @Author ronye
 * @Created 2019/1/12 - 9:38 PM
 * 编写一个实体类(bean)和数据表进行映射，并且配置好映射关系;
 */

@Entity
@Table(name="tb_user")//如不指定参数，默认就是类名小写user作为表名
public class User {

    public Integer getId ( ) {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getLastName ( ) {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    @Id  //标志这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增型主键
    private Integer id;
    @Column(name = "last_name",length = 50)
    private String lastName;
    @Column//省略默认列名就是属性名
    private String email;
}
