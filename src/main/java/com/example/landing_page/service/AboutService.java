package com.example.landing_page.service;

import com.example.landing_page.entity.About;
import com.example.landing_page.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutService {

    @Autowired
    private AboutRepository aboutRepository;

    public List<About> getAllAboutSections() {
        return aboutRepository.findAll();
    }

    public About saveAboutSection(About about) {
        return aboutRepository.save(about);
    }

    public About getAboutSectionById(int id) {
        return aboutRepository.findById(id).orElse(null);
    }
}
