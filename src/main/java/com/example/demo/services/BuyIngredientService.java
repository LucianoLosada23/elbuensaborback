package com.example.demo.services;

import com.example.demo.entity.BuyIngredient;
import com.example.demo.repository.BuyIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyIngredientService {

    private final BuyIngredientRepository repo;

    public List<BuyIngredient> findAll() { return repo.findAll(); }
    public Optional<BuyIngredient> findById(Integer id) { return repo.findById(id); }
    public BuyIngredient save(BuyIngredient e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
