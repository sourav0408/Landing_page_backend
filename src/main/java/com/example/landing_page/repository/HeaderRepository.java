package com.example.landing_page.repository;

import com.example.landing_page.entity.Faq;
import com.example.landing_page.entity.Header;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaderRepository extends JpaRepository<Header, Long> {
}
