package org.example.boomvim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReqDto {
    private int people_count;
    private String status;
    private LocalDateTime timestamp;

    public ReqDto(int peopleCount, String status) {
        this.people_count = peopleCount;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
