package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"orderDetailList","partner"})
@EntityListeners(AuditingEntityListener.class)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    //Item N : 1 Partner
    @ManyToOne
    private Partner partner;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

    //1 : N
    //LAZY 지연로딩 select * from item where id = ? //관련있는 테이블만 가져오겠다.
    //EAGER 즉시로딩 JOIN item item0_left outer join order_detail ...//연관된 모든 테이블을 조회하겠다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;


}
