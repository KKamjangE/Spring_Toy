package com.toy.web.response;

import lombok.Getter;

@Getter
public enum Result {
    SUCCESS("0", "성공"),
    CREATED("1", "생성 완료"),
    DELETE("2", "삭제 완료"),
    ALREADY_CREATED("3", "이미 저장된 데이터 입니다."),

    SIGN_IN_MATCH_FAIL("10001", "아이디 또는 비밀번호가 일치하지 않습니다."),
    SIGN_UP_ALREADY_ID("10002", "이미 존재하는 아이디 입니다."),
    SIGN_UP_FAIL("10003", "회원가입에 실패했습니다."),
    NOT_FOUND("10004", "해당 데이터를 찾을 수 없습니다.");

    private final String code;

    private final String description;

    Result(String code, String description){
        this.code = code;
        this.description = description;
    }

}
