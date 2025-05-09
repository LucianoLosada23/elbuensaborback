package com.example.demo.services;

import com.example.demo.entity.ProductIngredient;
import com.example.demo.repository.ProductIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductIngredientService {

    private final ProductIngredientRepository repo;

    public List<ProductIngredient> findAll() { return repo.findAll(); }
    public Optional<ProductIngredient> findById(Integer id) { return repo.findById(id); }
    public ProductIngredient save(ProductIngredient e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
