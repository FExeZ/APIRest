package ar.com.fez.tech.APIRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.fez.tech.APIRest.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByName(String name);
}
