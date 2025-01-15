package com.chooseulike;

import com.chooseulike.entity.Shop;
import com.chooseulike.service.impl.ShopServiceImpl;
import com.chooseulike.utils.CacheClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static com.chooseulike.utils.RedisConstants.CACHE_SHOP_KEY;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChooseWhatULikeApplicationTests {
    @Resource
    private ShopServiceImpl shopServiceImpl;
    @Autowired
    private CacheClient cacheClient;

    @Test
    public void testSaveShop() {
        Shop shop = shopServiceImpl.getById(1L);
        cacheClient.setWithLogicalExpire(CACHE_SHOP_KEY + 1L,shop,10L, TimeUnit.SECONDS);
    }
}
