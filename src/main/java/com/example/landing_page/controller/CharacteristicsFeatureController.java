package com.example.landing_page.controller;

import com.example.landing_page.entity.CharacteristicsFeature;
import com.example.landing_page.service.CharacteristicsFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characteristics_features")
public class CharacteristicsFeatureController {

    private final CharacteristicsFeatureService characteristicsFeatureService;

    @Autowired
    public CharacteristicsFeatureController(CharacteristicsFeatureService characteristicsFeatureService) {
        this.characteristicsFeatureService = characteristicsFeatureService;
    }

    @GetMapping("/all")
    public List<CharacteristicsFeature> getAllFeatures() {
        return characteristicsFeatureService.getAllFeatures();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacteristicsFeature> getFeatureById(@PathVariable Long id) {
        return characteristicsFeatureService.getFeatureById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<CharacteristicsFeature> addFeature(@RequestBody CharacteristicsFeature feature) {
        CharacteristicsFeature savedFeature = characteristicsFeatureService.saveFeature(feature);
        return ResponseEntity.status(201).body(savedFeature);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        characteristicsFeatureService.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }
}
