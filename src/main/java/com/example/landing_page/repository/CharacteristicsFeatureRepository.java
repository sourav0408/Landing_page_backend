package com.example.landing_page.repository;


import com.example.landing_page.entity.CharacteristicsFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicsFeatureRepository extends JpaRepository<CharacteristicsFeature, Long> {
}