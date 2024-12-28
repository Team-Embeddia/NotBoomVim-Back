package org.example.boomvim.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    NOT_FOUND_LAST_HOUR(404, "최근 1시간 전 데이터가 없습니다");

    private final int httpStatus;
    private final String message;
}
