package com.example.landing_page.controller;

import com.example.landing_page.entity.Faq;
import com.example.landing_page.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
public class FaqController {

    private final FaqService faqService;

    @Autowired
    public FaqController(FaqService faqService) {
        this.faqService = faqService;
    }


    @PostMapping("/save")
    public ResponseEntity<Faq> saveFaq(@RequestBody Faq faq) {
        Faq savedFaq = faqService.saveFaq(faq);
        return new ResponseEntity<>(savedFaq, HttpStatus.CREATED);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Faq>> getAllFaqs() {
        List<Faq> faqs = faqService.getAllFaqs();
        return new ResponseEntity<>(faqs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFaq(@PathVariable Long id) {
        faqService.deleteFaq(id);
        return ResponseEntity.noContent().build();
    }
}