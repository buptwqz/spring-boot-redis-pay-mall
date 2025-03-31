package com.chooseulike.controller;


import cn.hutool.json.JSONUtil;
import com.chooseulike.dto.Result;
import com.chooseulike.entity.ShopType;
import com.chooseulike.service.IShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static com.chooseulike.utils.RedisConstants.SHOP_TYPE_KEY;

@RestController
@RequestMapping("/shop-type")
public class ShopTypeController {
    @Resource
    private IShopTypeService typeService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("list")
    public Result queryTypeList() {
        // 查询redis缓存
        List<String> shopTypeListInRedis = stringRedisTemplate.opsForList().range(SHOP_TYPE_KEY, 0, -1);

        // 判断是否存在
        if (!shopTypeListInRedis.isEmpty()) {
            List<ShopType> shopTypeList = shopTypeListInRedis.stream().map(item -> {
                return JSONUtil.toBean(item, ShopType.class);
            }).collect(Collectors.toList());
            return Result.ok(shopTypeList);
        }

        // 查询数据库
        List<ShopType> shopTypeList = typeService
                .query().orderByAsc("sort").list();
        List<String> reslist = shopTypeList.stream().map(item -> {
            return JSONUtil.toJsonStr(item);
        }).collect(Collectors.toList());

        // 写入redis
        stringRedisTemplate.opsForList().rightPushAll(SHOP_TYPE_KEY, reslist);

        return Result.ok(shopTypeList);
    }
}
