package com.example.landing_page.service;

import com.example.landing_page.entity.Features;
import com.example.landing_page.repository.FeaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeaturesService {

    @Autowired
    private FeaturesRepository featuresRepository;

    public List<Features> getAllFeatures() {
        return featuresRepository.findAll();
    }

    public Optional<Features> getFeatureById(Long id) {
        return featuresRepository.findById(id);
    }

    public Features createFeature(Features feature) {
        return featuresRepository.save(feature);
    }

    public Features updateFeature(Long id, Features featureDetails) {
        Optional<Features> optionalFeature = featuresRepository.findById(id);
        if (optionalFeature.isPresent()) {
            Features feature = optionalFeature.get();
            feature.setIcon(featureDetails.getIcon());
            feature.setTitle(featureDetails.getTitle());
            feature.setText(featureDetails.getText());
            return featuresRepository.save(feature);
        } else {
            throw new RuntimeException("Feature not found with id " + id);
        }
    }

    public void deleteFeature(Long id) {
        featuresRepository.deleteById(id);
    }
}
