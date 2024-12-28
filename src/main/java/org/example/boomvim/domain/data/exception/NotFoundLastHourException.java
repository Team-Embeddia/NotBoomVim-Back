package org.example.boomvim.domain.data.exception;

import org.example.boomvim.global.exception.CustomException;
import org.example.boomvim.global.exception.ErrorCode;

public class NotFoundLastHourException extends CustomException {
    public NotFoundLastHourException() {
        super(ErrorCode.NOT_FOUND_LAST_HOUR);
    }
}
