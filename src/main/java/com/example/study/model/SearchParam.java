package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //기본생성자
public class SearchParam {

    private String account;
    private String email;
    private int page;

}
