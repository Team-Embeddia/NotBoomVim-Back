package org.example.boomvim.domain.data.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.boomvim.domain.data.dto.AggAllRes;
import org.example.boomvim.domain.data.entity.Aggregation;
import org.example.boomvim.domain.data.exception.NotFoundLastHourException;
import org.example.boomvim.domain.data.repository.AggregationRepository;
import org.example.boomvim.domain.data.service.GetAllAggService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GetAllAggServiceImpl implements GetAllAggService {
    private final AggregationRepository aggregationRepository;
    public AggAllRes execute() {
        List<Aggregation> allData = aggregationRepository.findAll();

        if (allData.isEmpty()) {
            throw new NotFoundLastHourException();
        }

        int count = allData.size();

        return new AggAllRes(count, allData);
    }
}
