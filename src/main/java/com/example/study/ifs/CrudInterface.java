package com.example.study.ifs;

import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;

public interface CrudInterface {

    Header<UserApiResponse> create(UserApiRequest request); // todo request object 추가

    Header read(Long id);

    Header update();

    Header delete(Long id);

}
