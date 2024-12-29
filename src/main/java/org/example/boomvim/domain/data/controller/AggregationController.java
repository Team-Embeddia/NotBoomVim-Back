package org.example.boomvim.domain.data.controller;

import lombok.RequiredArgsConstructor;
import org.example.boomvim.domain.data.entity.Aggregation;
import org.example.boomvim.domain.data.service.Get6HourAggService;
import org.example.boomvim.domain.data.service.GetAnHourAggService;
import org.example.boomvim.domain.data.service.GetDayAggService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BoomVim")
@RequiredArgsConstructor
public class AggregationController {
    private final GetAnHourAggService getAnHourAggService;
    private final Get6HourAggService get6HourAggService;
    private final GetDayAggService getDayAggService;

    @GetMapping("/anHour")
    public ResponseEntity<List<Aggregation>> getLastHourData() {
        List<Aggregation> getRes = getAnHourAggService.execute();
        return ResponseEntity.ok(getRes);
    }

    @GetMapping("/sixHour")
    public ResponseEntity<List<Aggregation>> get6HourData() {
        List<Aggregation> get6Res = get6HourAggService.execute();
        return ResponseEntity.ok(get6Res);
    }

    @GetMapping("/Day")
    public ResponseEntity<List<Aggregation>> getDayData() {
        List<Aggregation> getDayRes = getDayAggService.execute();
        return ResponseEntity.ok(getDayRes);
    }
}
