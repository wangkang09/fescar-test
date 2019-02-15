package com.wangkang.controller;

import com.wangkang.api.AccountApi;
import com.wangkang.api.OrderApi;
import com.wangkang.mapper.AccountMapper;
import org.apache.dubbo.config.annotation.Reference;
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
//@Service(interfaceClass = AccountApi.class,timeout = 60000,protocol = "dubbo")
public class AccountController implements AccountApi {

    @Autowired
    //@Reference(check = false)
            OrderApi orderApi;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public void debit(String userId, int money) throws Exception {
        System.out.println(userId + " 扣款 " + money + " 元！");

        accountMapper.updateMoneyDebit(userId, money);

        throw new Exception("扣减余额出错！");

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
