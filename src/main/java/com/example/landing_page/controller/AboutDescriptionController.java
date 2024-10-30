package com.example.landing_page.controller;

import com.example.landing_page.entity.AboutDescription;
import com.example.landing_page.service.AboutDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/about_descriptions/")
public class AboutDescriptionController {

    @Autowired
    private AboutDescriptionService aboutDescriptionService;

    @GetMapping("find/all")
    public List<AboutDescription> getAllAboutDescriptions() {
        return aboutDescriptionService.getAllAboutDescriptions();
    }

    @GetMapping("about/{aboutId}")
    public List<AboutDescription> getDescriptionsByAboutId(@PathVariable int aboutId) {
        return aboutDescriptionService.getAboutDescriptionsByAboutId(aboutId);
    }

    @PostMapping("/save")
    public ResponseEntity<AboutDescription> createAboutDescription(@RequestBody AboutDescription aboutDescription) {
        AboutDescription savedDescription = aboutDescriptionService.saveAboutDescription(aboutDescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDescription);
    }

    @GetMapping("/{id}")
    public AboutDescription getAboutDescriptionById(@PathVariable Long id) {
        return aboutDescriptionService.getAboutDescriptionById(id);
    }
}

/*@RestController
@RequestMapping("api/about_descriptions")
public class AboutDescriptionController {

    @Autowired
    private AboutDescriptionService aboutDescriptionService;

    @GetMapping("find/all")
    public List<AboutDescription> getAllAboutDescriptions() {
        return aboutDescriptionService.getAllAboutDescriptions();
    }

    @PostMapping("/save")
    public AboutDescription createAboutDescription(@RequestBody AboutDescription aboutDescription) {
        return aboutDescriptionService.saveAboutDescription(aboutDescription);
    }



    @GetMapping("/{about_id}")
    public AboutDescription getAboutDescriptionById(@PathVariable Long id) {
        return aboutDescriptionService.getAboutDescriptionById(id);
    }
}*/
