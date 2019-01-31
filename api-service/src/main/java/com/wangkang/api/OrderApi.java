package com.wangkang.api;

import com.wangkang.entity.Order;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:13 2019/1/31
 * @Modified By:
 */
public interface OrderApi {
    /**
     * create order
     */
    Order create(String userId, String commodityCode, int orderCount) throws Exception;

    String helloOrder();

    String helloAccount();
}
