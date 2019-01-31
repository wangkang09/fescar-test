package com.wangkang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 11:43 2019/1/31
 * @Modified By:
 */
@Configuration
//也可以用绝对路径 locations= {"file:d:/test/application-bean1.xml"
@ImportResource(locations = {"classpath:dubbo.xml"})
public class DubboConfig {
}
