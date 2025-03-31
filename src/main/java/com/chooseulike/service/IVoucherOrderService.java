package com.chooseulike.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chooseulike.dto.Result;
import com.chooseulike.entity.VoucherOrder;

public interface IVoucherOrderService extends IService<VoucherOrder> {

    Result seckillVoucher(Long voucherId);

    Result createVoucherOrder(Long voucherId);
}
