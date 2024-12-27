package org.example.boomvim.domain.data.repository;

import org.example.boomvim.domain.data.entity.Aggregation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AggregationRepository extends JpaRepository<Aggregation, Long> {
}
