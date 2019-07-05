package com.dy.springbootmybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNameDruidConfig
 * @Description  Druid数据源配置
 * @Author dingyu
 * @Date2019/7/1 13:18
 * @Version V1.0
 **/
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    //创建Web监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initPara=new HashMap<>();
        initPara.put("loginUsername","admin");
        initPara.put("loginPassword","123456");
        initPara.put("allow","");
        initPara.put("deny","192.168.1.12");
        registrationBean.setInitParameters(initPara);
        return registrationBean;
    }

    //创建Filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String,String> initPara=new HashMap<>();
        initPara.put("","");
        filterRegistrationBean.setInitParameters(initPara);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
}
