package net.elau.example.springboototlpexample.web.response;

import net.elau.example.springboototlpexample.model.ProductType;

public record ProductResponse(Long id, String name, ProductType type) {
}
