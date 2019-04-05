package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.services.CategoryService;
import com.example.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public List<Product> listProducts(){
        return productService.listAllProducts();
    }

    @GetMapping("/products/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable("categoryId") Long categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }


    @CrossOrigin(origins = "*")
    @PostMapping("products/create")
    public Product saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return product;
    }

    @PutMapping("products/edit/{id}")
    public Product edit(@PathVariable("id") Long id, @RequestBody Product product){
        Product productOriginal = productService.getProductById(id);
        productOriginal.setName(product.getName());
        productOriginal.setPrice(product.getPrice());
        productOriginal.setCategory(product.getCategory());
        productService.saveProduct(productOriginal);
        return productOriginal;
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping("/products/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }
}
