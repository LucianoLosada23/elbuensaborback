package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sub_category_ingredient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategoryIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne
    @JoinColumn(name = "category_ingredient_id", unique = true)
    private CategoryIngredient categoryIngredient;
}
