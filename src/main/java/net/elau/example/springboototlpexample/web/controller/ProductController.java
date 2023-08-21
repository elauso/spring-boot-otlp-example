package net.elau.example.springboototlpexample.web.controller;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.val;
import net.elau.example.springboototlpexample.mapper.ProductMapper;
import net.elau.example.springboototlpexample.service.ProductService;
import net.elau.example.springboototlpexample.web.request.CreateProductRequest;
import net.elau.example.springboototlpexample.web.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final MeterRegistry meterRegistry;

    private final ProductMapper mapper;

    private final ProductService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductRequest createProductRequest, UriComponentsBuilder uriComponentsBuilder) {

        val registered = service.create(mapper.toDTO(createProductRequest));
        meterRegistry.counter("product.create", "successfully.created", "successfully.created").increment();

        val uriComponents = uriComponentsBuilder.path("/products/{id}").buildAndExpand(registered.id());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable("id") Long id) {
        return mapper.toResponse(service.findById(id));
    }
}
