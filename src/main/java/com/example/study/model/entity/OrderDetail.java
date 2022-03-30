package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //order_datail
@ToString(exclude = {"orderGroup","item"})
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// primary key
    private Long id;

    private String status;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

    //OrderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    //OrderDetail N : 1 Item
    @ManyToOne
    private Item item;


//    @ManyToOne
//    private Item item;
//    // orderDetail 입장에서 N : 1
//    @ManyToOne
//    private User user; //user_id 타입은 반드시 객체이름써야함

    private LocalDateTime orderAt;
    private LocalDateTime arrivalDate;
}
