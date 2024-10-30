package com.example.landing_page.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Team {
    @Id
    private Long id;
    private String image;
    private String name;
    private String job;
}
