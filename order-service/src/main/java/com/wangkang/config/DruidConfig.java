package com.wangkang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fescar.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 14:29 2019/1/31
 * @Modified By:
 */
@Configuration
public class DruidConfig {
//    @Value("${spring.datasource.druid.user}")
//    private String druidUser;
//
//    @Value("${spring.datasource.druid.password}")
//    private String druidPassword;

//    @Bean(destroyMethod = "close", initMethod = "init")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DruidDataSource druidDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        return druidDataSource;
//    }

    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    @Bean("dataSource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();

        DataSourceProxy dataSourceProxy = new DataSourceProxy(druidDataSource);
        return dataSourceProxy;
    }

//    /**
//     * 注册一个StatViewServlet
//     *
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
//        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(
//                new StatViewServlet(), "/druid/*");
//
//        servletRegistrationBean.addInitParameter("loginUsername", druidUser);
//        servletRegistrationBean.addInitParameter("loginPassword", druidPassword);
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
//
//    /**
//     * 注册一个：filterRegistrationBean
//     *
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean<WebStatFilter> druidStatFilter() {
//
//        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(
//                new WebStatFilter());
//
//        // 添加过滤规则.
//        filterRegistrationBean.addUrlPatterns("/*");
//
//        // 添加不需要忽略的格式信息.
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
}
