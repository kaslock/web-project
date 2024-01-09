package com.example.backend.controller;

import com.example.backend.domain.Sample;
import com.example.backend.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @PostMapping("/sample/new")
    public Long create(Sample sample) {
        return sampleService.join(sample);
    }
}
