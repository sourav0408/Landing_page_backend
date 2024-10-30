package com.example.landing_page.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Testimonial {
    @Id
    private Long id;
    private String img;
    private String text;
    private String name;
}
