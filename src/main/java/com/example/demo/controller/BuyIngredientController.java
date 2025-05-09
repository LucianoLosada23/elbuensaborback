package com.example.demo.controller;

import com.example.demo.entity.BuyIngredient;
import com.example.demo.services.BuyIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buy-ingredients")
@RequiredArgsConstructor
public class BuyIngredientController {

    private final BuyIngredientService svc;

    @GetMapping
    public List<BuyIngredient> all() {
        return svc.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyIngredient> byId(@PathVariable Integer id) {
        return svc.findById(id)
                  .map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BuyIngredient create(@RequestBody BuyIngredient e) {
        return svc.save(e);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuyIngredient> update(@PathVariable Integer id, @RequestBody BuyIngredient e) {
        return svc.findById(id)
                  .map(x -> { e.setId(id); return ResponseEntity.ok(svc.save(e)); })
                  .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (svc.findById(id).isPresent()) {
            svc.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
