package com.example.landing_page.controller;

import com.example.landing_page.entity.Faq;
import com.example.landing_page.entity.Header;
import com.example.landing_page.service.FaqService;
import com.example.landing_page.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/header")
public class HeaderController {
    private final HeaderService headerService;
    @Autowired
    public HeaderController(HeaderService headerService) {
        this.headerService = headerService;
    }


    @PostMapping("/save")
    public ResponseEntity<Header> saveHeader(@RequestBody Header header) {
        Header savedHeader = headerService.saveHeader(header);
        return new ResponseEntity<>(savedHeader, HttpStatus.CREATED);
    }


    @GetMapping("/find/all")
    public ResponseEntity<List<Header>> getAllHeaders() {
        List<Header> headers = headerService.getAllHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
