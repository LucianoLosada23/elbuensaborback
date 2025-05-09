package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "buy")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dateBuy;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;
}
