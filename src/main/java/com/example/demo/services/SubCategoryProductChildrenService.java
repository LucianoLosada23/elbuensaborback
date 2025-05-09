package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SubCategoryProductChildren;
import com.example.demo.repository.SubCategoryProductChildrenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubCategoryProductChildrenService {

    private final SubCategoryProductChildrenRepository repo;

    public List<SubCategoryProductChildren> findAll() { return repo.findAll(); }
    public Optional<SubCategoryProductChildren> findById(Integer id) { return repo.findById(id); }
    public SubCategoryProductChildren save(SubCategoryProductChildren e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
