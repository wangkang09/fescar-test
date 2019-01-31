package com.wangkang.controller;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.wangkang.api.AccountApi;
import com.wangkang.api.OrderApi;
import com.wangkang.entity.Order;
import com.wangkang.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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
    /**
     *
     * @Description: 生成订单：首先，扣除客户count*price的款；然后生成详细订单
     *
     */
    @GlobalTransactional
    @Transactional
    public Order create(String userId, String commodityCode, int orderCount) throws Exception {

        // 计算订单金额
        int orderMoney = calculate(commodityCode, orderCount);

        // 从账户余额扣款
        accountApi.debit(userId, orderMoney);

        System.out.println(userId + " 扣款 " + orderMoney + "元！");

        Order order = new Order();
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);
        order.setUserId(userId);

        // INSERT INTO orders ...
        int result = orderMapper.insertSelective(order);

        System.out.println("订单生成成功！");

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
        return orderCount * 10;
    }
}
