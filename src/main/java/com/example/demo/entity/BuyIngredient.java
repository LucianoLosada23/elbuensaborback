package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "buy_ingredient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "buy_id")
    private Buy buy;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private BigDecimal quantity;

    private BigDecimal price;
}
