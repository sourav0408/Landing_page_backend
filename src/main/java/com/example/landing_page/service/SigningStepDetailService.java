package com.example.landing_page.service;

import com.example.landing_page.entity.SigningStep;
import com.example.landing_page.entity.SigningStepDetail;
import com.example.landing_page.repository.SigningStepDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SigningStepDetailService {

    @Autowired
    private SigningStepDetailRepository signingStepDetailRepository;

    // Retrieve all signing step details
    public List<SigningStepDetail> getAllSigningStepDetails() {
        return signingStepDetailRepository.findAll();
    }

    // Retrieve steps by signing step ID (category ID)
    public List<SigningStepDetail> getStepsBySigningStepId(Long signingStepId) {
        return signingStepDetailRepository.findBySigningStepId(signingStepId);
    }

    // Create or update a signing step detail
    public SigningStepDetail saveSigningStepDetail(SigningStepDetail signingStepDetail) {
        return signingStepDetailRepository.save(signingStepDetail);
    }

    // Delete a signing step detail by ID
    public void deleteSigningStepDetail(Long id) {
        signingStepDetailRepository.deleteById(id);
    }
}
