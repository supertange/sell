package com.supertange.sell.repository;

import com.supertange.sell.dataObject.OrderMaster;
import com.supertange.sell.enums.OrderStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setBuyerAddress("qwe");
        orderMaster.setBuyerName("asf");
        orderMaster.setBuyerOpenid("456");
        orderMaster.setBuyerPhone("1232131");
        orderMaster.setOrderAmount(BigDecimal.valueOf(1233));
        orderMaster.setOrderId("123");
        orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        orderMasterRepository.save(orderMaster);
    }

    @Test
    public void findByBuyerOpenid() {
        org.springframework.data.domain.Pageable request=new PageRequest(0,1);
        Page<OrderMaster> page=orderMasterRepository.findByBuyerOpenid("456",request);
        System.out.println(page.getContent());
    }
}