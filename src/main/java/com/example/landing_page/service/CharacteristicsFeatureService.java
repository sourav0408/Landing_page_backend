package com.example.landing_page.service;

import com.example.landing_page.entity.CharacteristicsFeature;
import com.example.landing_page.repository.CharacteristicsFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacteristicsFeatureService {

    @Autowired
    private CharacteristicsFeatureRepository characteristicsFeatureRepository;

    public List<CharacteristicsFeature> getAllFeatures() {
        return characteristicsFeatureRepository.findAll();
    }

    public Optional<CharacteristicsFeature> getFeatureById(Long id) {
        return characteristicsFeatureRepository.findById(id);
    }

    public CharacteristicsFeature saveFeature(CharacteristicsFeature feature) {
        return characteristicsFeatureRepository.save(feature);
    }

    public void deleteFeature(Long id) {
        characteristicsFeatureRepository.deleteById(id);
    }
}
