package com.dy.springbootmybatis.mapper;


import com.dy.springbootmybatis.entity.Employee;

public interface EmployeeMapper {

    public Employee getEmpl(Integer id);

    public int insertEmpl(Employee employee);

    public int delEmpl(Integer id);

    public int updEmpl(Employee employee);
}
