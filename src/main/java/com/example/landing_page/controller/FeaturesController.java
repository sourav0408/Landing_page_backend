package com.example.landing_page.controller;

import com.example.landing_page.entity.Features;
import com.example.landing_page.service.FeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/features")
public class FeaturesController {

    @Autowired
    private FeaturesService featuresService;

    @GetMapping("/find/all")
    public List<Features> getAllFeatures() {
        return featuresService.getAllFeatures();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Features> getFeatureById(@PathVariable Long id) {
        Optional<Features> feature = featuresService.getFeatureById(id);
        return feature.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Features createFeature(@RequestBody Features feature) {
        return featuresService.createFeature(feature);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Features> updateFeature(@PathVariable Long id, @RequestBody Features featureDetails) {
        try {
            Features updatedFeature = featuresService.updateFeature(id, featureDetails);
            return ResponseEntity.ok(updatedFeature);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        featuresService.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }
}