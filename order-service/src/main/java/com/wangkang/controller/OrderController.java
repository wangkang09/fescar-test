package com.wangkang.controller;

import com.wangkang.api.AccountApi;
import com.wangkang.api.OrderApi;
import com.wangkang.entity.Order;
import com.wangkang.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:15 2019/1/31
 * @Modified By:
 */
@RestController
public class OrderController implements OrderApi {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    AccountApi accountApi;

    @Override
    public Order create(String userId, String commodityCode, int orderCount) throws Exception {

        int orderMoney = calculate(commodityCode, orderCount);

        accountApi.debit(userId, orderMoney);

        Order order = new Order();
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);
        order.setUserId(userId);

        // INSERT INTO orders ...
        int result = orderMapper.insert(order);

        if (result == 1) return order;

        throw new Exception("插入出错");
    }


    @GetMapping("/helloOrder")
    public String helloAccount() {
        System.out.println("helloOrder!");
        return accountApi.helloAccount();
    }

    @Override
    public String helloOrder() {
        System.out.println("helloOrder!");
        return "helloOrder";
    }

    private int calculate(String commodityCode, int orderCount) {
        return 10;
    }
}
