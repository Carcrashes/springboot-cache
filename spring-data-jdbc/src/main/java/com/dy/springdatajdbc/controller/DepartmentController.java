package com.dy.springdatajdbc.controller;

import com.dy.springdatajdbc.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassNameDepartmentController
 * @Description 部门控制类
 * @Author dingyu
 * @Date2019/7/1 11:21
 * @Version V1.0
 **/
@RestController
@RequestMapping("depa")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("list")
    public Map<String, Object> list() {
        List<Map<String, Object>> maps = departmentService.DepaList();
        return maps.get(0);
    }
}
