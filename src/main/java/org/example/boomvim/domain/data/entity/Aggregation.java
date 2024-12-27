package org.example.boomvim.domain.data.entity;

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
        this.timestamp = LocalDateTime.now();
    }

    @PrePersist
    public void prePersist() {
        this.timestamp = LocalDateTime.now();
    }
}
