package com.supertange.sell.repository;

import com.supertange.sell.dataObject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("123");
        orderDetail.setOrderId("123");
        orderDetail.setProductIcon("wqeqweqw");
        orderDetail.setProductName("1234");
        orderDetail.setProductPrice(new BigDecimal(1231));
        orderDetail.setProductQuantity(12321);
        orderDetail.setProductId("123123123123");
        orderDetailRepository.save(orderDetail);
    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> list=orderDetailRepository.findByOrderId("123");
        System.out.println(list);


    }
}