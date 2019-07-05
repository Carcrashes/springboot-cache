package com.dy.cache.service.impl;

import com.dy.cache.entity.Employee;
import com.dy.cache.mapper.EmployeeMapper;
import com.dy.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * @ClassNameEmployeeServiceImpl
 * @Description
 * @Author dingyu
 * @Date2019/7/2 12:18
 * @Version V1.0
 **/
@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getEmp(Integer id) {
        return employeeMapper.getEmp(id);
    }

    @Override
    public int delEmp(Integer id) {
        return employeeMapper.delEmp(id);
    }

    @Override
    public Employee updEmp(Employee employee) {
        return employeeMapper.updEmp(employee);
    }

    @Override
    public Employee addEmp(Employee employee) {
        return employeeMapper.addEmp(employee);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
            },
            put = {
                    @CachePut(value ="emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.gender")
            }
    )
    @Override
    public Employee getEmp(String lastName) {
        return employeeMapper.getEmpByName(lastName);
    }
}
