package com.supertange.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.supertange.sell.dataObject.OrderDetail;
import com.supertange.sell.dto.OrderDTO;
import com.supertange.sell.exception.ResultEnum;
import com.supertange.sell.exception.SellException;
import com.supertange.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        Gson gson=new Gson();
        List<OrderDetail> orderDetailList=new ArrayList<>();
        try {
            orderDetailList=orderDetailList=gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("对象转换不正确,string={}",orderForm.getItems());
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
