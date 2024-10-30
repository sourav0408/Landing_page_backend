package com.example.landing_page.repository;

import com.example.landing_page.entity.SigningStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SigningStepRepository extends JpaRepository<SigningStep, Long> {
}
