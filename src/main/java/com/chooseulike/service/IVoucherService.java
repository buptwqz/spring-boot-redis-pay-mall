package com.chooseulike.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chooseulike.dto.Result;
import com.chooseulike.entity.Voucher;

public interface IVoucherService extends IService<Voucher> {

    Result queryVoucherOfShop(Long shopId);

    void addSeckillVoucher(Voucher voucher);
}
