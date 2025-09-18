package com.warehouse.api.DTO;

public class SectionCreateDTO {
    private String code;

    public SectionCreateDTO() {}

    public SectionCreateDTO(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
