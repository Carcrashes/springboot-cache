package com.dy.springbootmybatis.entity;

/**
 * @ClassNameEmployee
 * @Description 员工实体类
 * @Author dingyu
 * @Date2019/7/1 13:46
 * @Version V1.0
 **/
public class Employee {

    private Integer id;

    private String lastName;

    private String email;

    private Integer gender;

    private Integer did;

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}
