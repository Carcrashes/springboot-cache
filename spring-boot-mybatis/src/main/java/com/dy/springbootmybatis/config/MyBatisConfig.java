package com.dy.springbootmybatis.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassNameMyBatisConfig
 * @Description mybatis 配置
 * @Author dingyu
 * @Date2019/7/1 16:24
 * @Version V1.0
 **/
@Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
       return new ConfigurationCustomizer(){
           @Override
           public void customize(org.apache.ibatis.session.Configuration configuration) {
                    //开启驼峰命名转换
                    configuration.setMapUnderscoreToCamelCase(true);
           }
       };
    }

}
