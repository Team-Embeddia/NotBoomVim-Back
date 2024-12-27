package org.example.boomvim.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.boomvim.domain.data.dto.AggregationResponse;
import org.example.boomvim.domain.data.entity.Aggregation;
import org.example.boomvim.domain.data.repository.AggregationRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
public class AggregationService {
    private final AggregationRepository aggregationRepository;
    private final String url = "http://192.168.1.26:5001/aggregate_status";

    @Scheduled(fixedRate = 3000)
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
