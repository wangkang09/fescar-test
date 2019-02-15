package com.wangkang.controller;

import com.wangkang.api.StorageApi;
import com.wangkang.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:07 2019/1/31
 * @Modified By:
 */
@Controller
public class StorageController implements StorageApi {

    @Autowired
    StorageMapper storageMapper;

    @Override
    /**
     *
     * @Description: 减少 code 的 count 个库存
     *
     */
    public void deduct(String commodityCode, int count) {

        storageMapper.updateDeduct(commodityCode, count);
        System.out.println("库存中心减少 " + commodityCode + " " + count + "个库存！");

    }

    @Override
    public String helloStorage() {
        return null;
    }
}
