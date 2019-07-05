package com.dy.springdatajpa.repository;

import com.dy.springdatajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassNameUserRpository
 * @Description jpa dao层操作
 * @Author dingyu
 * @Date2019/7/1 19:08
 * @Version V1.0
 **/
public interface UserRpository  extends JpaRepository<User,Integer> {
}
