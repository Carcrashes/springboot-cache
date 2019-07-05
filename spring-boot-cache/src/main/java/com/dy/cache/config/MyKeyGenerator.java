package com.dy.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.lang.reflect.Method;

/**
 * @ClassNameMyKeyGenerator
 * @Description 自定义键值生成器
 * @Author dingyu
 * @Date2019/7/5 11:30
 * @Version V1.0
 **/
//@Configuration
public class MyKeyGenerator implements KeyGenerator {

    //@Primary
    //@Bean
    //@Override
    public Object generate(Object target, Method method, Object... params) {
        return generateKey(params);
    }

    public Object generateKey(Object... params){
        if (params !=null && params.length >0){
            return "["+params[0]+"]";
        }
        return new SimpleKey(params);
    }
}
