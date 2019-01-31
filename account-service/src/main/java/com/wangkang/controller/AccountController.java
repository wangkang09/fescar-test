package com.wangkang.controller;

import com.wangkang.api.AccountApi;
import com.wangkang.api.OrderApi;
import com.wangkang.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:52 2019/1/31
 * @Modified By:
 */
@RestController
public class AccountController implements AccountApi {

    @Autowired
    OrderApi orderApi;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public void debit(String userId, int money) {
        System.out.println(userId + " 扣款 " + money + " 元！");

        accountMapper.updateMoneyDebit(userId,money);

    }

    public String helloAccount() {
        System.out.println("helloAccount!");
        return "helloAccount";
    }

    @Override
    @GetMapping("/helloAccount")
    public String helloOrder() {
        System.out.println("helloAccount!");
        return orderApi.helloOrder();
    }
}
