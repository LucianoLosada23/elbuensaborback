package com.example.demo.controller;

import com.example.demo.entity.SubCategoryIngredient;
import com.example.demo.services.SubCategoryIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcat-ingredients")
@RequiredArgsConstructor
public class SubCategoryIngredientController {

    private final SubCategoryIngredientService svc;

    @GetMapping public List<SubCategoryIngredient> all() { return svc.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoryIngredient> byId(@PathVariable Integer id) {
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping public SubCategoryIngredient create(@RequestBody SubCategoryIngredient e) { return svc.save(e); }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoryIngredient> update(@PathVariable Integer id, @RequestBody SubCategoryIngredient e) {
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
