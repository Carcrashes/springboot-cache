package com.dy.cache.entity;

/**
 * @ClassNameEmployee
 * @Description 员工实体类
 * @Author dingyu
 * @Date2019/7/2 11:23
 * @Version V1.0
 **/
public class Employee {

    private Integer id;

    private String lastName;

    private Integer gender;

    private String email;

    private Integer dId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
