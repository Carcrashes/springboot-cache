package com.dy.springbootmybatis.service;

import com.dy.springbootmybatis.entity.Department;

/**
 * 部门服务接口
 */
public interface DepartmentService {

    public Department getDepa(Integer id);

    public int insertDepa(Department department);

    public int deleteDepa(Integer id);

    public int updDepa(Department department);
}
