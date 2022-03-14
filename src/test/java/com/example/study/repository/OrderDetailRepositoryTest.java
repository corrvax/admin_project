package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("order detail creation is ok");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(5));
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("eunJo Kim");
        orderDetail.setOrderGroupId(1L);

        //어떤 상품?
        orderDetail.setItemId(406L);
        //어떤 사용자?
        //orderDetail.setUserId(1001L);

        orderDetail.setOrderAt(LocalDateTime.now());

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }

}
