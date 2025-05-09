package com.example.demo.services;

import com.example.demo.entity.OrderProduct;
import com.example.demo.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderProductService {

    private final OrderProductRepository repo;

    public List<OrderProduct> findAll() { return repo.findAll(); }
    public Optional<OrderProduct> findById(Integer id) { return repo.findById(id); }
    public OrderProduct save(OrderProduct e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
