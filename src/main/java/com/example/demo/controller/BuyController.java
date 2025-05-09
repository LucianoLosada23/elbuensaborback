package com.example.demo.controller;

import com.example.demo.entity.Buy;
import com.example.demo.services.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buys")
@RequiredArgsConstructor
public class BuyController {

    private final BuyService svc;

    @GetMapping public List<Buy> all() { return svc.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Buy> byId(@PathVariable Integer id) {
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping public Buy create(@RequestBody Buy e) { return svc.save(e); }

    @PutMapping("/{id}")
    public ResponseEntity<Buy> update(@PathVariable Integer id, @RequestBody Buy e) {
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
