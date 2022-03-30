package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@ToString(exclude = {"orderGroup"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
    private String status;
    private String email;
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    //User 1 : N OrderGroup
    //Lazy : 지연로딩 EAGER : 즉시로딩
    //OneToMany 이므로 List타입으로 받아옴
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")//orderGroup에 있는 변수명과 같아야함(user)
    private List<OrderGroup> orderGroupList;
}
