package org.example.boomvim.domain.data.repository;

import org.example.boomvim.domain.data.entity.Aggregation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AggregationRepository extends JpaRepository<Aggregation, Long> {
    List<Aggregation> findAllByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);
    List<Aggregation> findAll();
}
