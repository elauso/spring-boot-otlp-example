package net.elau.example.springboototlpexample.web.controller;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.elau.example.springboototlpexample.mapper.ProductMapper;
import net.elau.example.springboototlpexample.service.ProductService;
import net.elau.example.springboototlpexample.web.request.CreateProductRequest;
import net.elau.example.springboototlpexample.web.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final MeterRegistry meterRegistry;

    private final ProductMapper mapper;

    private final ProductService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateProductRequest createProductRequest, UriComponentsBuilder uriComponentsBuilder) {
        log.debug("m=create, msg=Registering product={}", createProductRequest);

        val registered = service.create(mapper.toDTO(createProductRequest));
        meterRegistry.counter("products.created", "type", createProductRequest.type().name()).increment();

        val uriComponents = uriComponentsBuilder.path("/products/{id}").buildAndExpand(registered.id());
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable("id") Long id) {
        log.debug("m=findById, msg=Searching for product with id={}", id);
        return mapper.toResponse(service.findById(id));
    }
}
