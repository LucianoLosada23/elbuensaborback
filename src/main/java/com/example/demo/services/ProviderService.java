package com.example.demo.services;

import com.example.demo.entity.Provider;
import com.example.demo.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderService {

    private final ProviderRepository repo;

    public List<Provider> findAll() { return repo.findAll(); }
    public Optional<Provider> findById(Integer id) { return repo.findById(id); }
    public Provider save(Provider e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
