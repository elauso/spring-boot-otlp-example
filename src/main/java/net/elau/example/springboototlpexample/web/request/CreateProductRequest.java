package net.elau.example.springboototlpexample.web.request;

import net.elau.example.springboototlpexample.model.ProductType;

public record CreateProductRequest(String name, ProductType type) {
}
