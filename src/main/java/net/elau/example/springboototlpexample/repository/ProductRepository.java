package net.elau.example.springboototlpexample.repository;

import net.elau.example.springboototlpexample.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
