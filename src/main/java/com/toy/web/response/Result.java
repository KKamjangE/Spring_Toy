package com.toy.web.response;

import lombok.Getter;

@Getter
public enum Result {
    SUCCESS("0", "성공"),
    CREATED("1", "생성 완료"),
    DELETE("2", "삭제 완료"),
    ALREADY_CREATED("3", "이미 저장된 데이터 입니다."),

    SIGN_IN_SUCCESS("00", "로그인 성공"),
    SIGN_IN_ID_MATCH_FAIL("01", "아이디가 맞지 않습니다."),
    SIGN_IN_PASSWORD_MATCH_FAIL("02", "비밀번호가 맞지 않습니다."),
    SIGN_UP_SUCCESS("10", "회원가입 성공"),
    SIGN_UP_FAIL("11", "회원가입에 실패했습니다."),

    NOT_FOUND("40", "해당 데이터를 찾을 수 없습니다.");

    private final String code;

    private final String description;

    Result(String code, String description){
        this.code = code;
        this.description = description;
    }

}
