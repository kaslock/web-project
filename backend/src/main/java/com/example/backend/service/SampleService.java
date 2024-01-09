package com.example.backend.service;

import com.example.backend.domain.Sample;
import com.example.backend.repository.SampleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SampleService {

    private final SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public Long join(Sample sample) {
        sampleRepository.save(sample);
        return sample.getId();
    }
}
