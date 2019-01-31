package com.wangkang.api;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:13 2019/1/31
 * @Modified By:
 */
public interface StorageApi {
    /**
     * deduct storage count
     */
    void deduct(String commodityCode, int count);

    String helloStorage();

}
