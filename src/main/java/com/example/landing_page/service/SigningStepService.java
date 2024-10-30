package com.example.landing_page.service;

import com.example.landing_page.entity.SigningStep;
import com.example.landing_page.repository.SigningStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SigningStepService {

    @Autowired
    private SigningStepRepository signingStepRepository;

    // Retrieve all signing steps
    public List<SigningStep> getAllSigningSteps() {
        return signingStepRepository.findAll();
    }

    // Retrieve signing step by ID
    public Optional<SigningStep> getSigningStepById(Long id) {
        return signingStepRepository.findById(id);
    }

    // Save or update signing step
    public SigningStep saveSigningStep(SigningStep signingStep) {
        return signingStepRepository.save(signingStep);
    }

    // Delete signing step by ID
    public void deleteSigningStep(Long id) {
        signingStepRepository.deleteById(id);
    }
}
