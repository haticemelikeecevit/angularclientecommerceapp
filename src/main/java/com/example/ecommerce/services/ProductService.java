package com.example.ecommerce.services;


import com.example.ecommerce.model.Product;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProductByCategoryId(Long categoryId) { return productRepository.findByCategoryId(categoryId); }

    public void deleteById(Long id) { productRepository.deleteById(id); }
}
