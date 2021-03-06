package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentType {

    CARD(0,"카드","카드 결제"),
    CASH(1,"현금","현금 결제"),
    TRANSFER(2, "이체", "자동 이체")
    ;

    private Integer id;
    private String title;
    private String description;
}
