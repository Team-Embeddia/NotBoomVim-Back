package org.example.boomvim.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aggregation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int peopleCount;
    private String status;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Aggregation(int peopleCount, String status) {
        this.peopleCount = peopleCount;
        this.status = status;
        this.timestamp = LocalDateTime.now();  // timestamp는 생성 시 자동으로 설정
    }

    @PrePersist
    public void prePersist() {
        this.timestamp = LocalDateTime.now();  // 현재 시간 설정
    }
}
