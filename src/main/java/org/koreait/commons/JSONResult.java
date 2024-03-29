package org.koreait.commons;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class JSONResult<T> {
    private boolean success;
    private HttpStatus status = HttpStatus.OK; // 기본응답 상태코드 200으로 설정
    private String message; // 에러 발생 시 메시지
    private T data; // 성공시 응답 데이터 (지네릭 사용)
}
