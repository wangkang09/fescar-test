package com.wangkang.service;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.wangkang.api.OrderApi;
import com.wangkang.api.StorageApi;
import com.wangkang.entity.Account;
import com.wangkang.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 17:33 2019/1/31
 * @Modified By:
 */
@Service
public class BusinessService {

    @Autowired
    StorageApi storageApi;

    @Autowired
    OrderApi orderApi;

    @Autowired
    AccountMapper accountMapper;

    @GlobalTransactional
    //@Transactional
    public void purchase(String userId, String commodityCode, int orderCount) throws Exception {

        Account account = new Account();
        account.setMoney(100);
        account.setUserId("test");
        accountMapper.insertSelective(account);

        storageApi.deduct(commodityCode, orderCount);

        orderApi.create(userId, commodityCode, orderCount);

        //throw new RuntimeException("xxx");

    }

}
