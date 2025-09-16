package com.warehouse.api.DTO;

public class AddressCreateDTO {
    private String Street;
    private String City;

    public AddressCreateDTO() {}

    public AddressCreateDTO(String street, String city) {
        this.Street = street;
        this.City = city;
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
}
