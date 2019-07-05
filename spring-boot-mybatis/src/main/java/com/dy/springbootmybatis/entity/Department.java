package com.dy.springbootmybatis.entity;

/**
 * @ClassNameDepartment
 * @Description 部门实体类
 * @Author dingyu
 * @Date2019/7/1 13:47
 * @Version V1.0
 **/
public class Department {

    private Integer id;

    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
