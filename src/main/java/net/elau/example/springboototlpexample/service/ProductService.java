package net.elau.example.springboototlpexample.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import net.elau.example.springboototlpexample.dto.CreateProductDTO;
import net.elau.example.springboototlpexample.dto.ProductDTO;
import net.elau.example.springboototlpexample.mapper.ProductMapper;
import net.elau.example.springboototlpexample.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper mapper;

    private final ProductRepository repository;

    @Transactional
    public ProductDTO create(CreateProductDTO createProductDTO) {
        val persisted = repository.save(mapper.toModel(createProductDTO));
        return mapper.toDTO(persisted);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        val persisted = repository.findById(id).orElseThrow();
        return mapper.toDTO(persisted);
    }
}
