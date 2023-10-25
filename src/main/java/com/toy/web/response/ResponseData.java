package com.toy.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor // 생성자를 자동으로 만들어 준다
@Builder
public class ResponseData<T> {
    private int statusCode;
    private String responseMessage;
    private T data;

    // 기본 초기화
    public ResponseData(final int statusCode, final String responseMessage) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    // 데이터가 없는 경우
    public static<T> ResponseData<T> res(final int statusCode, final String responseMessage) {
        return res(statusCode, responseMessage, null);
    }

    // 데이터가 있는 경우
    public static<T> ResponseData<T> res(final int statusCode, final String responseMessage, final T t) {
        return ResponseData.<T>builder()
                .data(t)
                .statusCode(statusCode)
                .responseMessage(responseMessage)
                .build();
    }
}
