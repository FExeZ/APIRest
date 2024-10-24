package ar.com.fez.tech.APIRest.services.implementedServices;

import java.util.List;

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
    public void createProduct(Product product) throws Exception {
        Product productDB = productRepository
                .findProductByName(product.getName());
        if (productDB != null) {
            throw new Exception("Product " + product.getName() + " already exists");
        } else {
            productRepository.save(product);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public void updateProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

}
