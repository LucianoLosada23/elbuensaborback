package com.example.demo.services;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repo;

    public List<Employee> findAll() { return repo.findAll(); }
    public Optional<Employee> findById(Integer id) { return repo.findById(id); }
    public Employee save(Employee e) { return repo.save(e); }
    public void delete(Integer id) { repo.deleteById(id); }
}
