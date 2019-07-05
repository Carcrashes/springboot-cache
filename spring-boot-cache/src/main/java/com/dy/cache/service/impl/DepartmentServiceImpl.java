package com.dy.cache.service.impl;

import com.dy.cache.entity.Department;
import com.dy.cache.mapper.DepartmentMapper;
import com.dy.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @ClassNameDepartmentServiceImpl
 * @Description
 * @Author dingyu
 * @Date2019/7/2 12:18
 * @Version V1.0
 **/
//@CacheConfig(cacheNames = "depa") 可以指定cacheName 类中其他缓存注解就可以cacheNames默认为CacheConfig配置注解
//可以设置默认的cacheManger 设置自定义的cacheManger
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Cacheable(cacheNames = "depa", key="#id")
    @Override
    public Department getDepa(Integer id){
        return departmentMapper.queryDepa(id);
    }


    @Cacheable(cacheNames = "depa",key = "#department.id")
    @Override
    public Department insertDepa(Department department){
        departmentMapper.insertDepa(department);
        return department;
    }


    @CacheEvict(cacheNames = "depa",key = "#id")
    @Override
    public int delDepa(Integer id){
        return departmentMapper.deleteDepa(id);
    }


    @CachePut(cacheNames = "depa",key = "#department.id")
    @Override
    public Department updDepa(Department department){
        departmentMapper.updDepa(department);
        return department;
    }

}
