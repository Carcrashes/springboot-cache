package com.dy.springdatajpa.entity;

import javax.persistence.*;

/**
 * @ClassNameUser
 * @Description
 * @Author dingyu
 * @Date2019/7/1 19:01
 * @Version V1.0
 **/
//jap 注解映射关系
@Entity //告诉jpa这是一个实体类
@Table(name = "user")  //指定和哪个数据表对应，如果省略默认表名为user
public class User {
    @Id //标注这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置自增主键
    private  Integer id;

    @Column(name="last_name",length = 50) //与数据表对应，长度为50
    private String name;

    @Column //省略默认列名为属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
