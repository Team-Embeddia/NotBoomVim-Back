package org.example.boomvim.domain.data.dto;

import lombok.Data;
import lombok.Getter;
import org.example.boomvim.domain.data.entity.Aggregation;

import java.util.List;

@Getter
public class AggAllRes {
    private int count;
    private List<Aggregation> data;

    public AggAllRes(int count, List<Aggregation> data) {
        this.count = data.size();
        this.data = data;
    }
}
