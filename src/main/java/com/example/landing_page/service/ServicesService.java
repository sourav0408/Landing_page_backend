package com.example.landing_page.service;

import com.example.landing_page.entity.Services;
import com.example.landing_page.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {

    @Autowired
    private ServicesRepository servicesRepository;


    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    public Optional<Services> getServiceById(Long id) {
        return servicesRepository.findById(id);
    }

    // Create a new service
    public Services createService(Services service) {
        return servicesRepository.save(service);
    }

    public Services updateService(Long id, Services serviceDetails) {
        Optional<Services> optionalService = servicesRepository.findById(id);
        if (optionalService.isPresent()) {
            Services service = optionalService.get();
            service.setIcon(serviceDetails.getIcon());
            service.setName(serviceDetails.getName());
            service.setText(serviceDetails.getText());
            return servicesRepository.save(service);
        } else {
            throw new RuntimeException("Service not found with id " + id);
        }
    }

    // Delete a service by ID
    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }
}


