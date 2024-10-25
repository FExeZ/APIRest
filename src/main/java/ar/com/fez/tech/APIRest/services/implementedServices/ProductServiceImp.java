package ar.com.fez.tech.APIRest.services.implementedServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.fez.tech.APIRest.entities.Product;
import ar.com.fez.tech.APIRest.repositories.ProductRepository;
import ar.com.fez.tech.APIRest.services.ProductService;

public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws Exception {
        Product productDB = productRepository
                .findProductByName(product.getName());
        if (productDB != null) {
            throw new Exception("Product " + product.getName() + " already exists");
        } else {
            return productRepository.save(product);
        }
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        Product productDB = productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
        productRepository.delete(productDB);
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        Product productDB = productRepository.findById(product.getId())
                .orElseThrow(() -> new Exception("Product not found"));
        productRepository.save(productDB);
    }

    @Override
    public Product findById(Long id) throws Exception {
        return productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

}
