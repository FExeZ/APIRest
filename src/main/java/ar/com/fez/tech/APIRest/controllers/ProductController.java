package ar.com.fez.tech.APIRest.controllers;

import java.util.List;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.fez.tech.APIRest.DTOs.CreateProductDto;
import ar.com.fez.tech.APIRest.entities.Product;
import ar.com.fez.tech.APIRest.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping // Get all products
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @SuppressWarnings("null")
    @GetMapping("/{id}") // Get product by id
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws Exception {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("null")
    @PostMapping // Register a product
    public ResponseEntity<?> createProduct(@RequestBody CreateProductDto productDto) throws Exception {
        ModelMapper mapper = new ModelMapper();
        Product productDB = mapper.map(productDto, Product.class);
        try {
            productService.createProduct(productDB);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @SuppressWarnings("null")
    @PutMapping("/{id}") // Updating a product by ID
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody CreateProductDto productDetails)
            throws Exception {
        Optional<Product> existingProductOpt = productService.getProductById(id);
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(productDetails.getName());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setQuantity(productDetails.getQuantity());
            productService.updateProduct(existingProduct);
            return new ResponseEntity<>(existingProduct, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("null")
    @DeleteMapping("/{id}") // Delete a product by ID
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws Exception {
        if (productService.getProductById(id).isPresent()) {
            productService.deleteProduct(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}