package com.example.landing_page.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pricing_feature")
public class PricingFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String featureName;

    @ManyToOne
    @JoinColumn(name = "pricing_class_id")
    @JsonBackReference
    private PricingClass pricingClass;

}
