package com.dy.springdatajdbc.service.impl;

import com.dy.springdatajdbc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassNameDepartmentServiceImpl
 * @Description
 * @Author dingyu
 * @Date2019/7/1 11:14
 * @Version V1.0
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Map<String, Object>> DepaList() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from department");
        return maps;
    }
}
