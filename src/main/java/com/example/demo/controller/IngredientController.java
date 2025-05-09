package com.example.demo.controller;

import com.example.demo.entity.Ingredient;
import com.example.demo.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService svc;

    @GetMapping public List<Ingredient> all() { return svc.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> byId(@PathVariable Integer id) {
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping public Ingredient create(@RequestBody Ingredient e) { return svc.save(e); }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> update(@PathVariable Integer id, @RequestBody Ingredient e) {
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
