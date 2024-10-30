package com.example.landing_page.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "SigningSteps")
public class SigningStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "signingStep", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SigningStepDetail> signingStepDetails; // Renamed for clarity

}
