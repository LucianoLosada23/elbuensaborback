package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dateOrder;

    private LocalDateTime finalizedTime;

    @Enumerated(EnumType.STRING)
    private TypeShipment typeShipment;

    private LocalDate createdAt;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
