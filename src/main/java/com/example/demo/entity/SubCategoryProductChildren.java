package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sub_category_product_children")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategoryProductChildren {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne
    @JoinColumn(name = "category_id", unique = true, nullable = false)
    private Category category;
}
