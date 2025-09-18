package com.warehouse.api.DTO;

public class ProductCreateDTO {
    private String sku;
    private String name;

    public ProductCreateDTO() {}

    public ProductCreateDTO(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
