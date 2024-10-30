package com.example.landing_page.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "pricing_class")
public class PricingClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name")
    private String className;

    private String price;

    @OneToMany(mappedBy = "pricingClass", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PricingFeature> features;

    @Column(name = "button_text")
    private String buttonText;

    @Column(name = "button_action")
    private String buttonAction;

}
