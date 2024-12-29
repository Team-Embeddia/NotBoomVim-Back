package org.example.boomvim.domain.data.service;

import org.example.boomvim.domain.data.entity.Aggregation;

import java.util.List;

public interface GetDayAggService {
    List<Aggregation> execute();
}
