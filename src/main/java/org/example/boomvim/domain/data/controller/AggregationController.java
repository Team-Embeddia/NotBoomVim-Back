package org.example.boomvim.domain.data.controller;

import lombok.RequiredArgsConstructor;
import org.example.boomvim.domain.data.entity.Aggregation;
import org.example.boomvim.domain.data.service.GetAggregationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BoomVim")
@RequiredArgsConstructor
public class AggregationController {
    private final GetAggregationService getAggregationService;

    @GetMapping("/anHour")
    public ResponseEntity<List<Aggregation>> getLastHourData() {
        List<Aggregation> getRes = getAggregationService.execute();
        return ResponseEntity.ok(getRes);
    }
}
