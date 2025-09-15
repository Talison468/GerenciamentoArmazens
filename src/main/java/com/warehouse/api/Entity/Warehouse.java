package com.warehouse.api.Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false)
    private String nome;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
