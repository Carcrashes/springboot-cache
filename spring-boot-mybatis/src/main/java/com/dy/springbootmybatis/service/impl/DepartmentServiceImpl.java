package com.dy.springbootmybatis.service.impl;

import com.dy.springbootmybatis.entity.Department;
import com.dy.springbootmybatis.mapper.DepartmentMapper;
import com.dy.springbootmybatis.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassNameDepartmentServiceImpl
 * @Description
 * @Author dingyu
 * @Date2019/7/1 15:57
 * @Version V1.0
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepa(Integer id) {
        return departmentMapper.getDepa(id);
    }

    @Override
    public int insertDepa(Department department) {
        return departmentMapper.insertDepa(department);
    }

    @Override
    public int deleteDepa(Integer id) {
        return departmentMapper.deleteDepa(id);
    }

    @Override
    public int updDepa(Department department) {
        return departmentMapper.updDepa(department);
    }
}
