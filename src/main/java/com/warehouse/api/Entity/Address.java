package com.warehouse.api.Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false)
    private String Street;
    @Column(nullable = false)
    private String City;

    @OneToOne(mappedBy = "address")
    private Warehouse warehouse;

    public Address() {}

    public Address(UUID id, String street, String city, Warehouse warehouse) {
        this.id = id;
        this.Street = street;
        this.City = city;
        this.warehouse = warehouse;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
