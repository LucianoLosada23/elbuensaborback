package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService svc;

    @GetMapping public List<Employee> all() { return svc.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> byId(@PathVariable Integer id) {
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping public Employee create(@RequestBody Employee e) { return svc.save(e); }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody Employee e) {
        return svc.findById(id)
            .map(x -> { e.setId(id); return ResponseEntity.ok(svc.save(e)); })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (svc.findById(id).isPresent()) { svc.delete(id); return ResponseEntity.noContent().build(); }
        return ResponseEntity.notFound().build();
    }
}
