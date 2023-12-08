package com.toy.web.response;

import java.util.Map;

public class ResponseSuccess extends Response {
    private static final String DEFAULT_CODE = Result.SUCCESS.getCode(); // 기본 성공 code
    private static final String DEFAULT_MESSAGE = Result.SUCCESS.getDescription(); // 기본 성공 msg
    private Map<String, Object> response; // code와 msg가 들어갈 멤버

    public ResponseSuccess() {
    }

    public ResponseSuccess(Map<String, Object> response) { // 생성자를 통해 response를 받음
        this.response = response;
    }

    @Override
    protected String resultCode() { // 추상 메서드 구현
        if (isValidResponseContext(response)) { // response가 없다면 기본 code 반환
            return DEFAULT_CODE;
        } else {
            return String.valueOf(response.get("code")); // response객체에서 code라는 키로 값 추출
        }
    }

    @Override
    protected String resultMessage() {
        if (isValidResponseContext(response)) {
            return DEFAULT_MESSAGE;
        } else {
            return String.valueOf(response.get("msg"));
        }
    }

    private boolean isValidResponseContext(Map<String, Object> response) { // 응답이 유효한지 확인하는 메서드
        return response == null || response.isEmpty();
    }

}
