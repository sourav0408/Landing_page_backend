package com.example.landing_page.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String section_name;

    @OneToMany(mappedBy = "about", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AboutDescription> aboutdescription; // Reference to AboutDescription
}