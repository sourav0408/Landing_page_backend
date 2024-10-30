package com.example.landing_page.repository;

import com.example.landing_page.entity.PricingClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingClassRepository extends JpaRepository<PricingClass, Long> {
}