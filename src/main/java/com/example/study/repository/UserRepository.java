package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {//user 기본키 id 의 타입이 Long

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);


}
