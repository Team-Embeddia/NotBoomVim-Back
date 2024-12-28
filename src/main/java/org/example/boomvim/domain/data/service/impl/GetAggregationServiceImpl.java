package org.example.boomvim.domain.data.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.boomvim.domain.data.entity.Aggregation;
import org.example.boomvim.domain.data.exception.NotFoundLastHourException;
import org.example.boomvim.domain.data.repository.AggregationRepository;
import org.example.boomvim.domain.data.service.GetAggregationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GetAggregationServiceImpl implements GetAggregationService {
    private final AggregationRepository aggregationRepository;

    public List<Aggregation> execute() {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(1);

        List<Aggregation> recentData = aggregationRepository.findAllByTimestampBetween(startTime, endTime);

        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);

        if (recentData.isEmpty()) {
            throw new NotFoundLastHourException();
        }

        return recentData;
    }
}
