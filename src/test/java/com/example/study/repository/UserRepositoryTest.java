package com.example.study.repository;

import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@DataJpaTest// JPA 테스트 관련 컴포넌트만 Import
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    // 실제 db 사용
@DisplayName("UserRepositoryTest 테스트")
public class UserRepositoryTest {

    //Dependency Injection
    @Autowired
    private UserRepository userRepository;

    //@Rollback(value = false)
    @Test
    public void create() {
        String account = "Test2022";
        String password = "Test2022";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);


        //User객체 생성시 여러종류 생성자 추가할때마다 Entity에 변경 필요
        //->Builder()어노테이션추가해서 간단하게 여러종류의 생성자 생성없이 객체 생성 가능
        User u = User.builder()
            .account(account)
            .password(password)
            .email(email)
            .build();

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);

    }
    @Test
    @Transactional
    public void  read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("----------주문묶음----------------");
            System.out.println("수령인 : "+ orderGroup.getRevName());
            System.out.println("총금액 : " + orderGroup.getTotalPrice());
            System.out.println("수령지 : " + orderGroup.getRevAddress());
            System.out.println("총수량 : " + orderGroup.getTotalQuantity());

            System.out.println("--------------주문상세-------------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름 :" + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리 :" + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문상품 : " + orderDetail.getItem().getName());
                System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 :" + orderDetail.getStatus());
                System.out.println("도착 예정 일자 :" + orderDetail.getArrivalDate());
            });


        });


        Assertions.assertNotNull(user);

    }

    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent( selectUser -> {
            selectUser.setAccount("update account");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    public void delete(){
        Optional<User> user = userRepository.findById(2L);

        Assertions.assertTrue(user.isPresent());// true :  data 존재

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        Assertions.assertFalse(deleteUser.isPresent());//false
    }

}
