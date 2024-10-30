package com.example.landing_page.repository;
import com.example.landing_page.entity.PricingFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingFeatureRepository extends JpaRepository<PricingFeature, Long> {
}