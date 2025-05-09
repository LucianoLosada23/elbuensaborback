package com.example.demo.controller;

import com.example.demo.entity.ProductIngredient;
import com.example.demo.services.ProductIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-ingredients")
@RequiredArgsConstructor
public class ProductIngredientController {

    private final ProductIngredientService svc;

    @GetMapping public List<ProductIngredient> all() { return svc.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<ProductIngredient> byId(@PathVariable Integer id) {
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping public ProductIngredient create(@RequestBody ProductIngredient e) { return svc.save(e); }

    @PutMapping("/{id}")
    public ResponseEntity<ProductIngredient> update(@PathVariable Integer id, @RequestBody ProductIngredient e) {
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
