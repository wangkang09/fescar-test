package com.wangkang.api;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:06 2019/1/31
 * @Modified By:
 */
public interface BusinessApi {
    /**
     * 用户订购商品
     *
     * @param userId        用户ID
     * @param commodityCode 商品编号
     * @param orderCount    订购数量
     */
    void purchase(String userId, String commodityCode, int orderCount) throws Exception;
}
