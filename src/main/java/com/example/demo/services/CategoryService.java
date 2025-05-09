package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repo;

    public List<Category> findAll() { return repo.findAll(); }
    public Optional<Category> findById(Integer id) { return repo.findById(id); }
    public Category save(Category cat) { return repo.save(cat); }
    public void delete(Integer id) { repo.deleteById(id); }
}
