package com.example.study.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {
    //api 통신시간
    private String transactionTime;
    //api 응답 코드
    private String resultCode;
    //api 부가 설명
    private String description;
    //변경될 data
    private T data;

}