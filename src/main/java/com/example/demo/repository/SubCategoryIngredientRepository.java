package com.example.demo.repository;

import com.example.demo.entity.SubCategoryIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryIngredientRepository extends JpaRepository<SubCategoryIngredient, Integer> {
}
