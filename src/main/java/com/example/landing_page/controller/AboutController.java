package com.example.landing_page.controller;

import com.example.landing_page.entity.About;
import com.example.landing_page.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about")
public class AboutController {

    @Autowired
    private AboutService aboutService;

    @GetMapping
    public List<About> getAllAboutSections() {
        return aboutService.getAllAboutSections();
    }

    @PostMapping("/save")
    public About createAboutSection(@RequestBody About about) {
        return aboutService.saveAboutSection(about);
    }

    @GetMapping("/{id}")
    public About getAboutSectionById(@PathVariable int id) {
        return aboutService.getAboutSectionById(id);
    }
}
