package com.example.landing_page.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SigningStepDetail")
public class SigningStepDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer stepNumber;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "signing_step_id", nullable = false)
    @JsonBackReference
    private SigningStep signingStep;



}
