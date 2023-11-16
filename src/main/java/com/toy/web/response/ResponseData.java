package com.toy.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor // 생성자를 자동으로 만들어 준다
@Builder
public class ResponseData<T> {
    private String code;
    private String message;
    private T data;

    // 기본 초기화
    public ResponseData(final String code, final String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    // 데이터가 없는 경우
    public static<T> ResponseData<T> res(final String code, final String message) {
        return res(code, message, null);
    }

    // 데이터가 있는 경우
    public static<T> ResponseData<T> res(final String code, final String message, final T t) {
        return ResponseData.<T>builder()
                .data(t)
                .code(code)
                .message(message)
                .build();
    }
}
