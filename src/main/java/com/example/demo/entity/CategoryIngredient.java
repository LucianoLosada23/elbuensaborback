package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category_ingredient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
