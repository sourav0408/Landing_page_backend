package com.example.landing_page.service;

import com.example.landing_page.entity.Header;
import com.example.landing_page.repository.HeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeaderService {
    private final HeaderRepository headerRepository;

    @Autowired
    public HeaderService(HeaderRepository headerRepository) {
        this.headerRepository = headerRepository;
    }

    public Header saveHeader(Header header) {
        return headerRepository.save(header);
    }


    public List<Header> getAllHeaders() {  // Corrected method name
        return headerRepository.findAll();
    }
}