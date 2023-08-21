package net.elau.example.springboototlpexample.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated(STRING)
    @Column(nullable = false, length = 11)
    private ProductType type;

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", type=" + type + '}';
    }
}
