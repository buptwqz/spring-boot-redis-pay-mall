package com.chooseulike.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chooseulike.dto.Result;
import com.chooseulike.entity.Shop;

public interface IShopService extends IService<Shop> {

    Result queryById(Long id);

    Result update(Shop shop);
}
