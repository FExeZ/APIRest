package ar.com.fez.tech.APIRest.services;

import java.util.List;

import ar.com.fez.tech.APIRest.entities.Product;

public interface ProductService {

    List<Product> getProducts();

    void createProduct(Product product) throws Exception;

    void deleteProduct(Product product);

    void updateProduct(Product product);

}
