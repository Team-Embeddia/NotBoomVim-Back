package org.example.boomvim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReqDto {
    private int people_count;
    private String status;
    private String timestamp;
}
