package com.example.demo.services;

import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository repo;

    public List<Ingredient> findAll() { return repo.findAll(); }
    public Optional<Ingredient> findById(Integer id) { return repo.findById(id); }
    public Ingredient save(Ingredient e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
