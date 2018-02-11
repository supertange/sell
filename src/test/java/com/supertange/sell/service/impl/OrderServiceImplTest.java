package com.supertange.sell.service.impl;

import com.supertange.sell.dataObject.OrderDetail;
import com.supertange.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String BUYER_OPENID="110120";
    private final String ORDER_ID="1518323225829797547";
    @Autowired
    private OrderServiceImpl orderService;
    @Test
    public void create() {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("李依金");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList=new ArrayList<>();

        OrderDetail ol=new OrderDetail();
        ol.setProductId("123458");
        ol.setProductQuantity(2);
        orderDetailList.add(ol);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result=orderService.create(orderDTO);
        log.info("[创建订单]result={}",result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        log.info("查询单个订单",orderDTO.getOrderId());
        Assert.assertEquals(ORDER_ID,orderDTO.getOrderId());

    }

    @Test
    public void findList() {
        PageRequest request=new PageRequest(0,2);
        Page<OrderDTO> page=orderService.findList(BUYER_OPENID,request);
        log.info("总元素",page.getTotalElements());
        System.out.println(page.getContent());
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}