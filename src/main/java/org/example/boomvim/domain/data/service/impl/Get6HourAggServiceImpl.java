package org.example.boomvim.domain.data.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.boomvim.domain.data.entity.Aggregation;
import org.example.boomvim.domain.data.exception.NotFoundLastHourException;
import org.example.boomvim.domain.data.repository.AggregationRepository;
import org.example.boomvim.domain.data.service.Get6HourAggService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Get6HourAggServiceImpl implements Get6HourAggService {
    private final AggregationRepository aggregationRepository;

    public List<Aggregation> execute() {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusHours(6);

        List<Aggregation> allData = aggregationRepository.findAllByTimestampBetween(startTime, endTime);

        if (allData.isEmpty()) {
            throw new NotFoundLastHourException();
        }

        if(allData.size() <= 12) {
            return allData;
        }

        List<Aggregation> result = new ArrayList<>();
        int step = allData.size() / 12;

        for (int i = 0; i < 12; i++) {
            result.add(allData.get(i * step));
        }
        return result;
    }
}