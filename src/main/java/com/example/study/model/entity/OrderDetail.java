package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //order_datail
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// primary key
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private LocalDateTime createdAt;

    private String createdBy;

    private Long orderGroupId;

    private Long itemId;
    // orderDetail 입장에서 N : 1
    @ManyToOne
    private User user; //user_id 타입은 반드시 객체이름써야함

    private LocalDateTime orderAt;
}
