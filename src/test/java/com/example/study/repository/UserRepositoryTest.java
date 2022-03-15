package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

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
        user.setAccount("TestUser04");
        user.setPassword("password0404");
        user.setStatus("ok");
        user.setEmail("TestUser04@gmail.com");
        user.setPhoneNumber("010-4444-4444");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("eunJo");

        User newUser = userRepository.save(user);//parameter 넣은 객체를 반환함
        System.out.println("newUser :" +newUser);

    }
    @Test
    @Transactional
    public void  read(){
        Optional<User> user = userRepository.findByAccount("TestUser04");

//        user.ifPresent(selectUser ->{
//            selectUser.getOrderDetailList().stream().forEach(detail -> {
//                System.out.println(detail.getId());
//            });
//        });

    }

    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent( selectUser -> {
            selectUser.setAccount("update account");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent());// true :  data 존재

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assertions.assertFalse(deleteUser.isPresent());//false
    }

}
