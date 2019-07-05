package com.dy.springbootmybatis.service.impl;

import com.dy.springbootmybatis.entity.Employee;
import com.dy.springbootmybatis.mapper.EmployeeMapper;
import com.dy.springbootmybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameEmployeeServiceImpl
 * @Description  员工服务接口实现类
 * @Author dingyu
 * @Date2019/7/1 16:59
 * @Version V1.0
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getEmpl(Integer id) {
        return employeeMapper.getEmpl(id);
    }

    @Override
    public int insertEmpl(Employee employee) {
        return employeeMapper.insertEmpl(employee);
    }
}
