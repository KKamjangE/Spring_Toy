package com.toy.web.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public abstract class Response { // 공통 응답 추상 클래스

    @Getter
    @AllArgsConstructor // 생성자
    public static class Body { // 상수 클래스
        private String code; // 상태 코드
        private String message; // 메시지
        private Object data; // 응답 데이터
    }

    public ResponseEntity<Body> success() { // 응답 데이터가 없는 성공
        return new ResponseEntity<>(getBody(Optional.empty()), HttpStatus.OK);
    }

    public ResponseEntity<Body> success(Object data) { // 응답 데이터가 있는 성공
        return new ResponseEntity<>(getBody(data), HttpStatus.OK);
    }

    public ResponseEntity<Body> fail() { // 응답 데이터가 없는 실패
        return new ResponseEntity<>(getBody(Optional.empty()), HttpStatus.OK);
    }

    public ResponseEntity<Body> fail(Object data) { // 응답 데이터가 있는 실패
        return new ResponseEntity<>(getBody(data), HttpStatus.OK);
    }

    public ResponseEntity<Body> internalError() { // 서버 에러
        return new ResponseEntity<>(getBody(Optional.empty()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Body getBody(Object data) { // 응답 body
        return new Body(resultCode(), resultMessage(), data);
    }

    protected abstract String resultCode(); // 응답 상태 코드 추상화 메서드

    protected abstract String resultMessage(); // 응답 메시지 추상화 메서드

}
