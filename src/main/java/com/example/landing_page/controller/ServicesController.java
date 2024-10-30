package com.example.landing_page.controller;

import com.example.landing_page.entity.Services;
import com.example.landing_page.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping("/find/all")
    public List<Services> getAllServices() {
        return servicesService.getAllServices();
    }

    @PostMapping("/save")
    public Services createService(@RequestBody Services services) {
        return servicesService.createService(services);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Services> updateService(
            @PathVariable Long id, @RequestBody Services serviceDetails) {
        Services updatedService = servicesService.updateService(id, serviceDetails);
        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        servicesService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
