package net.elau.example.springboototlpexample.mapper;

import net.elau.example.springboototlpexample.dto.CreateProductDTO;
import net.elau.example.springboototlpexample.dto.ProductDTO;
import net.elau.example.springboototlpexample.model.Product;
import net.elau.example.springboototlpexample.web.request.CreateProductRequest;
import net.elau.example.springboototlpexample.web.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    CreateProductDTO toDTO(CreateProductRequest createProductRequest);

    ProductDTO toDTO(Product product);

    Product toModel(CreateProductDTO createProductDTO);

    ProductResponse toResponse(ProductDTO productDTO);
}
