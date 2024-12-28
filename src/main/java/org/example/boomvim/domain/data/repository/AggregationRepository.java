package org.example.boomvim.domain.data.repository;

import org.example.boomvim.domain.data.entity.Aggregation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AggregationRepository extends JpaRepository<Aggregation, Long> {
    List<Aggregation> findAllByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);
}
