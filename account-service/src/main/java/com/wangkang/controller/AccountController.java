package com.wangkang.controller;

import com.wangkang.api.AccountApi;
import com.wangkang.api.OrderApi;
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

    @Override
    public void debit(String userId, int money) {

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
