package com.example.backend.repository;

import com.example.backend.domain.Sample;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SampleRepository {
    private final EntityManager em;

    public void save(Sample sample) {
        em.persist(sample);
    }

    public Optional<Sample> findById(Long id) {
        Sample sample = em.find(Sample.class, id);
        return Optional.ofNullable(sample);
    }
}
