package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(name = "time_estimate")
    private Integer timeEstimate;

    private Double price;

    private String image;

    @ManyToOne
    @JoinColumn(name = "sub_category_product_children", unique = true, nullable = false)
    private SubCategoryProductChildren subCategoryProductChildren;
}
