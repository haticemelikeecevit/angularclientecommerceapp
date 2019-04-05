package com.example.ecommerce.repositories;

import com.example.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(Long aLong);

    @Override
    Category save(Category category);
}
