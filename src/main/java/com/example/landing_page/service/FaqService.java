package com.example.landing_page.service;

import com.example.landing_page.entity.Faq;
import com.example.landing_page.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {

    private final FaqRepository faqRepository;

    @Autowired
    public FaqService(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }


    public Faq saveFaq(Faq faq) {
        return faqRepository.save(faq);
    }


    public List<Faq> getAllFaqs() {
        return faqRepository.findAll();
    }
    public void deleteFaq(Long id) {
        faqRepository.deleteById(id);
    }
}