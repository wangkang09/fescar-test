package com.wangkang.api;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:12 2019/1/31
 * @Modified By:
 */
public interface AccountApi {

    /**
     * debit balance of user's account
     */
    void debit(String userId, int money);

    String helloOrder();

    String helloAccount();

}
