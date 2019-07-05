package com.dy.cache.config;

import com.alibaba.druid.pool.DruidDataSource;
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
 * @Description Druid数据源配置
 * @Author dingyu
 * @Date2019/7/1 11:37
 * @Version V1.0
 **/

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    //配置Druid监控
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> initPara = new HashMap<>();
        initPara.put("loginUsername", "admin");
        initPara.put("loginPassword", "123465");
        initPara.put("allow", ""); //默认允许所有访问
        initPara.put("deny", "192.168.8.12");
        registrationBean.setInitParameters(initPara);
        return registrationBean;
    }

    //配置Filter监控
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new WebStatFilter());
        Map<String, String> initPara = new HashMap<>();
        initPara.put("exclusions", "*.js,*.css,/druid/*");
        registrationBean.setInitParameters(initPara);
        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        return registrationBean;
    }
}
