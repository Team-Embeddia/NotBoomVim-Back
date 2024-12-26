package org.example.boomvim.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.boomvim.dto.AggregationResponse;
import org.example.boomvim.entity.Aggregation;
import org.example.boomvim.repository.AggregationRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
public class AggregationService {
    private final AggregationRepository aggregationRepository;
    private final String url = "http://192.168.1.26:5001/aggregate_status";

    @Scheduled(fixedRate = 1000)
    public void fetchDataAndSaveToDatabase() {
        RestTemplate restTemplate = new RestTemplate();
        AggregationResponse response = restTemplate.getForObject(url, AggregationResponse.class);

        if (response != null) {
            Aggregation aggregateStatus = new Aggregation(response.getPeople_count(), response.getStatus());

            aggregationRepository.save(aggregateStatus);
            System.out.println("Data saved to DB: " + aggregateStatus);
        }
    }
}
