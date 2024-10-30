/*
package com.example.landing_page.service;

import com.example.landing_page.entity.PricingClass;
import com.example.landing_page.entity.PricingFeature;
import com.example.landing_page.repository.PricingClassRepository;
import com.example.landing_page.repository.PricingFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PricingService {

    @Autowired
    private PricingClassRepository pricingClassRepository;

    @Autowired
    private PricingFeatureRepository pricingFeatureRepository;

    @Transactional
    public PricingClass savePricingClass(PricingClass pricingClass) {
        pricingClass.getFeatures().forEach(feature -> feature.setPricingClass(pricingClass));
        return pricingClassRepository.save(pricingClass);
    }

    public List<PricingClass> getAllPricingClasses() {
        return pricingClassRepository.findAll();
    }

    public PricingClass getPricingClassById(Long id) {
        return pricingClassRepository.findById(id).orElse(null);
    }

    public List<PricingFeature> getAllFeatures() {
        return pricingFeatureRepository.findAll();
    }

    public PricingFeature getFeatureById(Long id) {
        return pricingFeatureRepository.findById(id).orElse(null);
    }
}


*/

package com.example.landing_page.service;

import com.example.landing_page.entity.PricingClass;
import com.example.landing_page.entity.PricingFeature;
import com.example.landing_page.repository.PricingClassRepository;
import com.example.landing_page.repository.PricingFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PricingService {

    @Autowired
    private PricingClassRepository pricingClassRepository;

    @Autowired
    private PricingFeatureRepository pricingFeatureRepository;

    @Transactional
    public PricingClass savePricingClass(PricingClass pricingClass) {
        pricingClass.getFeatures().forEach(feature -> feature.setPricingClass(pricingClass));
        return pricingClassRepository.save(pricingClass);
    }

    public List<PricingClass> getAllPricingClasses() {
        return pricingClassRepository.findAll();
    }

    public PricingClass getPricingClassById(Long id) {
        return pricingClassRepository.findById(id).orElse(null);
    }

    public List<PricingFeature> getAllFeatures() {
        return pricingFeatureRepository.findAll();
    }

    public PricingFeature getFeatureById(Long id) {
        return pricingFeatureRepository.findById(id).orElse(null);
    }

    @Transactional
    public PricingClass updatePricingClass(Long id, PricingClass updatedPricingClass) {
        if (pricingClassRepository.existsById(id)) {
            updatedPricingClass.setId(id);
            return pricingClassRepository.save(updatedPricingClass);
        }
        return null; // or throw an exception
    }

    @Transactional
    public boolean deletePricingClass(Long id) {
        if (pricingClassRepository.existsById(id)) {
            pricingClassRepository.deleteById(id);
            return true;
        }
        return false; // or throw an exception
    }

    @Transactional
    public PricingFeature saveFeature(PricingFeature feature) {
        return pricingFeatureRepository.save(feature);
    }

    @Transactional
    public PricingFeature updateFeature(Long id, PricingFeature updatedFeature) {
        if (pricingFeatureRepository.existsById(id)) {
            updatedFeature.setId(id);
            return pricingFeatureRepository.save(updatedFeature);
        }
        return null; // or throw an exception
    }

    @Transactional
    public boolean deleteFeature(Long id) {
        if (pricingFeatureRepository.existsById(id)) {
            pricingFeatureRepository.deleteById(id);
            return true;
        }
        return false; // or throw an exception
    }

}
