package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ingredient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private BigDecimal price;

    private BigDecimal quantity;

    @Enumerated(EnumType.STRING)
    private UnitOfMeasurement unitOfMeasurement;

    private Boolean state;

    @Column(name = "stock_min")
    private BigDecimal stockMin;

    @Column(name = "stock_actual")
    private BigDecimal stockActual;

    @Column(name = "stock_max")
    private BigDecimal stockMax;

    @OneToOne
    @JoinColumn(name = "subCategoryIngredient_id", unique = true)
    private SubCategoryIngredient subCategoryIngredient;
}
