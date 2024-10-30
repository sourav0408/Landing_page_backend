package com.example.landing_page.controller;

import com.example.landing_page.entity.SigningStep;
import com.example.landing_page.entity.SigningStepDetail;
import com.example.landing_page.service.SigningStepService;
import com.example.landing_page.service.SigningStepDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/signing-steps")
public class SigningStepController {

    @Autowired
    private SigningStepService signingStepService;

    @Autowired
    private SigningStepDetailService signingStepDetailService;

    // Get all signing steps (categories)
    @GetMapping
    public List<SigningStep> getAllSigningSteps() {
        return signingStepService.getAllSigningSteps();
    }

    // Get a specific signing step by ID
    @GetMapping("/{id}")
    public ResponseEntity<SigningStep> getSigningStepById(@PathVariable Long id) {
        Optional<SigningStep> signingStep = signingStepService.getSigningStepById(id);
        return signingStep.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create or update a signing step
    @PostMapping("/save")
    public ResponseEntity<SigningStep> saveSigningStep(@RequestBody SigningStep signingStep) {
        try {
            // Set parent reference for each detail
            if (signingStep.getSigningStepDetails() != null) {
                for (SigningStepDetail detail : signingStep.getSigningStepDetails()) {
                    detail.setSigningStep(signingStep); // Set the parent reference
                }
            }
            SigningStep savedStep = signingStepService.saveSigningStep(signingStep);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedStep);
        } catch (DataIntegrityViolationException e) {
            // Log specific exception for data integrity issues
            e.printStackTrace(); // Consider logging this instead of printing
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            // Log general exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a signing step by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSigningStep(@PathVariable Long id) {
        signingStepService.deleteSigningStep(id);
        return ResponseEntity.noContent().build();
    }

    // Get steps (instructions) by signing step ID
    @GetMapping("/{signingStepId}/details")
    public List<SigningStepDetail> getSigningStepDetails(@PathVariable Long signingStepId) {
        return signingStepDetailService.getStepsBySigningStepId(signingStepId);
    }

    // Add or update a specific step within a signing step
    @PostMapping("/{signingStepId}/details")
    public SigningStepDetail addOrUpdateSigningStepDetail(@PathVariable Long signingStepId, @RequestBody SigningStepDetail signingStepDetail) {
        signingStepDetail.setSigningStep(new SigningStep()); // Associate with the main category
        signingStepDetail.getSigningStep().setId(signingStepId); // Set the ID
        return signingStepDetailService.saveSigningStepDetail(signingStepDetail);
    }

    // Delete a specific step by ID
    @DeleteMapping("/details/{id}")
    public ResponseEntity<Void> deleteSigningStepDetail(@PathVariable Long id) {
        signingStepDetailService.deleteSigningStepDetail(id);
        return ResponseEntity.noContent().build();
    }
}
