package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;
    private String password;
    private String name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Client client;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee;
}
