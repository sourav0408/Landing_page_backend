package com.example.landing_page.controller;

import com.example.landing_page.entity.PricingClass;
import com.example.landing_page.entity.PricingFeature;
import com.example.landing_page.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @PostMapping("/save")
    public ResponseEntity<PricingClass> savePricingClass(@RequestBody PricingClass pricingClass) {
        PricingClass savedPricingClass = pricingService.savePricingClass(pricingClass);
        return new ResponseEntity<>(savedPricingClass, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PricingClass>> getAllPricingClasses() {
        List<PricingClass> pricingClasses = pricingService.getAllPricingClasses();
        return new ResponseEntity<>(pricingClasses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PricingClass> getPricingClassById(@PathVariable Long id) {
        PricingClass pricingClass = pricingService.getPricingClassById(id);
        if (pricingClass != null) {
            return new ResponseEntity<>(pricingClass, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/features/all")
    public ResponseEntity<List<PricingFeature>> getAllFeatures() {
        List<PricingFeature> features = pricingService.getAllFeatures();
        return new ResponseEntity<>(features, HttpStatus.OK);
    }

    @GetMapping("/features/{id}")
    public ResponseEntity<PricingFeature> getFeatureById(@PathVariable Long id) {
        PricingFeature feature = pricingService.getFeatureById(id);
        if (feature != null) {
            return new ResponseEntity<>(feature, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PricingClass> updatePricingClass(@PathVariable Long id, @RequestBody PricingClass updatedPricingClass) {
        PricingClass pricingClass = pricingService.updatePricingClass(id, updatedPricingClass);
        if (pricingClass != null) {
            return new ResponseEntity<>(pricingClass, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePricingClass(@PathVariable Long id) {
        if (pricingService.deletePricingClass(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

