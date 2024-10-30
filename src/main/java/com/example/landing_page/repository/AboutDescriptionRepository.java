package com.example.landing_page.repository;

import com.example.landing_page.entity.AboutDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*public interface AboutDescriptionRepository extends JpaRepository<AboutDescription, Long> {
}*/


public interface AboutDescriptionRepository extends JpaRepository<AboutDescription, Long> {
    List<AboutDescription> findByAbout_Id(int aboutId);
}

/*
public interface AboutDescriptionRepository extends JpaRepository<AboutDescription, Long> {
    @Query("SELECT ad FROM AboutDescription ad WHERE ad.about.id = :aboutId")
    List<AboutDescription> findByAboutId(@Param("aboutId") int aboutId);
}*/
