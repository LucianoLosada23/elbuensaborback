package com.example.demo.services;

import com.example.demo.entity.SubCategoryIngredient;
import com.example.demo.repository.SubCategoryIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubCategoryIngredientService {

    private final SubCategoryIngredientRepository repo;

    public List<SubCategoryIngredient> findAll() { return repo.findAll(); }
    public Optional<SubCategoryIngredient> findById(Integer id) { return repo.findById(id); }
    public SubCategoryIngredient save(SubCategoryIngredient e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
