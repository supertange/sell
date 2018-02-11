package com.supertange.sell.service;

import com.supertange.sell.dto.OrderDTO;

public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO ordercancel(String openid,String orderId);

}
