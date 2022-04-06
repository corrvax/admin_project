package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    //1. request data
    //2. user 생성
    //3. 생성된 데이터 -> UserApiResponse return

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder()
            .account(userApiRequest.getAccount())
            .password(userApiRequest.getPassword())
            .status("REGISTERED")
            .phoneNumber(userApiRequest.getPhoneNumber())
            .email(userApiRequest.getEmail())
            .registeredAt(LocalDateTime.now())
            .build();

        User newUser = userRepository.save(user);

        // 3. 생성된 데이터 기준으로 userApiResponse return


        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user){
        //user -> userApiResponse 생성 후 return
        UserApiResponse userApiResponse = UserApiResponse.builder()
            .id(user.getId())
            .account(user.getAccount())
            .password(user.getPassword())
            .email(user.getEmail())
            .phoneNumber(user.getPhoneNumber())
            .status(user.getStatus())
            .registeredAt(user.getRegisteredAt())
            .unRegisteredAt(user.getUnregisteredAt())
            .build();
        //Header + data -> return
        return Header.OK(userApiResponse);

    }


}