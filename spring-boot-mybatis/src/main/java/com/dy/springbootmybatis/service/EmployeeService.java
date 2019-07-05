package com.dy.springbootmybatis.service;

import com.dy.springbootmybatis.entity.Employee;

/**
 * @ClassNameEmployeeService
 * @Description 员工服务接口类
 * @Author dingyu
 * @Date2019/7/1 16:57
 * @Version V1.0
 **/
public interface EmployeeService {

    public Employee getEmpl(Integer id);

    public int insertEmpl(Employee employee);
}
