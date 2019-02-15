package com.wangkang.controller;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.wangkang.api.BusinessApi;
import com.wangkang.api.OrderApi;
import com.wangkang.api.StorageApi;
import com.wangkang.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:07 2019/1/31
 * @Modified By:
 */
@RestController
public class BusinessController implements BusinessApi {

    @Autowired
    BusinessService businessService;

    @Override
    @GetMapping("/purchase")
    public void purchase(String userId, String commodityCode, int orderCount) throws Exception {

        System.out.println(userId + " 开始购买 " + orderCount + " 个" + commodityCode + " 商品！");

        businessService.purchase(userId, commodityCode, orderCount);

    }
}
