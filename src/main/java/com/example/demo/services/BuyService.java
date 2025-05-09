package com.example.demo.services;

import com.example.demo.entity.Buy;
import com.example.demo.repository.BuyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyService {

    private final BuyRepository repo;

    public List<Buy> findAll() { return repo.findAll(); }
    public Optional<Buy> findById(Integer id) { return repo.findById(id); }
    public Buy save(Buy e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
