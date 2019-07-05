package com.dy.springbootmybatis.controller;

import com.dy.springbootmybatis.entity.Department;
import com.dy.springbootmybatis.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameDepartmentController
 * @Description  部门控制类
 * @Author dingyu
 * @Date2019/7/1 15:59
 * @Version V1.0
 **/
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/depa/{id}")
    public Department getDepa(@PathVariable("id") Integer id){
        return departmentService.getDepa(id);
    }

    @PostMapping("/depa/add")
    public int add(Department department){
        return departmentService.insertDepa(department);
    }

    @PostMapping("/depa/del/{id}")
    public int del(@PathVariable("id") Integer id){
        return departmentService.deleteDepa(id);
    }

    @PostMapping("/depa/upd")
    public int upd(Department department){
        return departmentService.updDepa(department);
    }
}

