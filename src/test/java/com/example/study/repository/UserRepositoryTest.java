package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

//@DataJpaTest// JPA 테스트 관련 컴포넌트만 Import
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
//@DisplayName("UserRepositoryTest 테스트")
public class UserRepositoryTest extends StudyApplicationTests {

    //Dependency Injection
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        //user.setId(); Auto Increment 라서 자동으로 id 1씩 증가함
        user.setAccount("TestUser01");
        user.setEmail("TestUser@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("eunJo");

        User newUser = userRepository.save(user);//parameter로 넣은 객체를 반환함
        System.out.println("newUser :" +newUser);

    }

//    public void read(){
//
//    }
//
//    public void update(){
//
//    }
//
//    public void delete(){
//
//    }
}
