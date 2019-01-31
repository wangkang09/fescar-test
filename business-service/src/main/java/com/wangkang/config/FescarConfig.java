package com.wangkang.config;

import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 14:33 2019/1/31
 * @Modified By:
 */
@Configuration
public class FescarConfig {
    @Value("${spring.application.name}")
    private String applicationId;

    /**
     *
     * @return
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        GlobalTransactionScanner globalTransactionScanner = new GlobalTransactionScanner(applicationId, "receivables");
        return globalTransactionScanner;
    }
}
