package ar.com.fez.tech.APIRest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.fez.tech.APIRest.entities.Product;

@Service
public interface ProductService {

    List<Product> getProducts();

    Product createProduct(Product product) throws Exception;

    void deleteProduct(Long id) throws Exception;

    void updateProduct(Product product) throws Exception;

    Optional<Product> getProductById(Long id);

}
