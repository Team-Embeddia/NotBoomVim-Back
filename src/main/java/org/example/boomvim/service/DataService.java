package org.example.boomvim.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.boomvim.dto.ReqDto;
import org.example.boomvim.entity.Data;
import org.example.boomvim.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class DataService {
    private final DataRepository dataRepository;

    public void saveDataRecord(ReqDto dto) {
        Data data = Data.builder()
                .people_count(dto.getPeople_count())
                .status(dto.getStatus())
                .timestamp(dto.getTimestamp())
                .build();

        dataRepository.save(data);
    }
}
