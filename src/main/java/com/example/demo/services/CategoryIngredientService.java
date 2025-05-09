package com.example.demo.services;

import com.example.demo.entity.CategoryIngredient;
import com.example.demo.repository.CategoryIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryIngredientService {

    private final CategoryIngredientRepository repo;

    public List<CategoryIngredient> findAll() { return repo.findAll(); }
    public Optional<CategoryIngredient> findById(Integer id) { return repo.findById(id); }
    public CategoryIngredient save(CategoryIngredient e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
