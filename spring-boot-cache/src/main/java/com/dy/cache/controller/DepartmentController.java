package com.dy.cache.controller;

import com.dy.cache.entity.Department;
import com.dy.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameDepartmentController
 * @Description 部门控制类
 * @Author dingyu
 * @Date2019/7/2 11:28
 * @Version V1.0
 **/
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/depa/get/{id}")
    public Department getDepa(@PathVariable("id") Integer id){
        return departmentService.getDepa(id);
    }

    @PostMapping("/depa/add")
    public Department insertDepa(Department department){

        return  departmentService.insertDepa(department);
    }

    @PostMapping("/depa/upd")
    public Department updDepa(Department department){
         return  departmentService.updDepa(department);
    }

    @PostMapping("/depa/del/{id}")
    public int delDepa(@PathVariable("id") Integer id){
        return departmentService.delDepa(id);
    }
}
