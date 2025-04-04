package ar.com.fez.tech.APIRest.DTOs;

import lombok.Data;

@Data
public class CreateProductDto {
    private String name;
    private String description;
    private double price;
    private Integer quantity;
}
