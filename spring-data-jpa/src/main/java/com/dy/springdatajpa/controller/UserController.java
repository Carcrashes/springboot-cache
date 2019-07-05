package com.dy.springdatajpa.controller;

import com.dy.springdatajpa.entity.User;
import com.dy.springdatajpa.repository.UserRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @ClassNameUserController
 * @Description
 * @Author dingyu
 * @Date2019/7/1 19:16
 * @Version V1.0
 **/
@RestController
public class UserController {

    @Autowired
    private UserRpository userRpository;

    @PostMapping("/user/get/{id}")
    public User getUser(@PathVariable("id") Integer id){
        Optional<User> byId = userRpository.findById(id);
        return byId.get();
    }
    
    @PostMapping("/user/add")
    public User addUser(User user){
        User save = userRpository.save(user);
        return save;
    }
}
