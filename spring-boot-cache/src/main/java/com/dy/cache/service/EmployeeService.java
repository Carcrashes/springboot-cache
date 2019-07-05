package com.dy.cache.service;

import com.dy.cache.entity.Employee;

public interface EmployeeService {

     Employee getEmp(Integer id);

     int delEmp(Integer id);

     Employee updEmp(Employee employee);

     Employee addEmp(Employee employee);

     Employee getEmp(String lastName);


}
