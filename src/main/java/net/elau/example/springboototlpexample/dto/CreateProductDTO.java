package net.elau.example.springboototlpexample.dto;

import net.elau.example.springboototlpexample.model.ProductType;

public record CreateProductDTO(String name, ProductType type) {
}
