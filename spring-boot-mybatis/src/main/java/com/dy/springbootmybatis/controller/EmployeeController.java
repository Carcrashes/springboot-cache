package com.dy.springbootmybatis.controller;

import com.dy.springbootmybatis.entity.Employee;
import com.dy.springbootmybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameEmployeeController
 * @Description 员工信息控制类
 * @Author dingyu
 * @Date2019/7/1 17:01
 * @Version V1.0
 **/
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp/get/{id}")
    public Employee getEmpl(@PathVariable("id") Integer id){
        return  employeeService.getEmpl(id);
    }

    @PostMapping("/emp/add")
    public int addEmpl(Employee employee){
        return employeeService.insertEmpl(employee);
    }
}
