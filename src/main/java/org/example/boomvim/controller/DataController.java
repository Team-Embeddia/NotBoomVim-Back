package org.example.boomvim.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.boomvim.dto.ReqDto;
import org.example.boomvim.entity.Data;
import org.example.boomvim.service.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/embeddia")
@RequiredArgsConstructor
public class DataController {
    private final DataService dataService;

    @PostMapping("/post")
    public ResponseEntity<Data> saveData(@RequestBody @Valid ReqDto dto) {
        dataService.saveDataRecord(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
