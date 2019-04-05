package com.example.ecommerce.bootstrap;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.services.CategoryService;
import com.example.ecommerce.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final CategoryService categoryService;
    private final ProductService productService;

    public DataLoader(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {

        Category categoryFirst = new Category();
        categoryFirst.setName("Çanta");

        Product productFirst = new Product();
        productFirst.setPrice(100L);
        productFirst.setCategory(categoryFirst);
        productFirst.setName("Sırt Çantası");

        Product productSecond = new Product();
        productSecond.setName("Kol Çantası");
        productSecond.setPrice(200L);
        productSecond.setCategory(categoryFirst);

        Category categorySecond = new Category();
        categorySecond.setName("Ayakkabı");

        Product productThird = new Product();
        productThird.setName("Spor Ayakkabı");
        productThird.setPrice(300L);
        productThird.setCategory(categorySecond);

        Product productForth = new Product();
        productForth.setName("Topuklu Ayakkabı");
        productForth.setPrice(200L);
        productForth.setCategory(categorySecond);

        categoryService.saveCategory(categoryFirst);
        categoryService.saveCategory(categorySecond);
        productService.saveProduct(productFirst);
        productService.saveProduct(productSecond);
        productService.saveProduct(productThird);
        productService.saveProduct(productForth);
    }
}
