package ar.com.fez.tech.APIRest.services;

import java.util.List;
import java.util.Optional;

import ar.com.fez.tech.APIRest.entities.Product;

public interface ProductService {

    List<Product> getProducts();

    Product createProduct(Product product) throws Exception;

    void deleteProduct(Long id) throws Exception;

    void updateProduct(Product product) throws Exception;

    Product findById(Long id) throws Exception;

    Optional<Product> getProductById(Long id);

}
