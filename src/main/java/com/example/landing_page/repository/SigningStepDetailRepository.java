package com.example.landing_page.repository;

import com.example.landing_page.entity.SigningStepDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SigningStepDetailRepository extends JpaRepository<SigningStepDetail, Long> {
    List<SigningStepDetail> findBySigningStepId(Long signingStepId);
}
