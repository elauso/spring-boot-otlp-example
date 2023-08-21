package net.elau.example.springboototlpexample.dto;

import net.elau.example.springboototlpexample.model.ProductType;

public record ProductDTO(Long id, String name, ProductType type) {
}
