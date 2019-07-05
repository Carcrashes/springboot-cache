package com.dy.cache.service;

import com.dy.cache.entity.Department;

/**
 * @ClassNameDepartmentService
 * @Description
 * @Author dingyu
 * @Date2019/7/2 11:29
 * @Version V1.0
 **/
public interface DepartmentService {

     Department getDepa(Integer id);

     Department insertDepa(Department department);

     int delDepa(Integer id);

     Department updDepa(Department department);
}
