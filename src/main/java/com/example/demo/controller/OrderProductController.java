package com.example.demo.controller;

import com.example.demo.entity.OrderProduct;
import com.example.demo.services.OrderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-products")
@RequiredArgsConstructor
public class OrderProductController {

    private final OrderProductService svc;

    @GetMapping public List<OrderProduct> all() { return svc.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<OrderProduct> byId(@PathVariable Integer id) {
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping public OrderProduct create(@RequestBody OrderProduct e) { return svc.save(e); }

    @PutMapping("/{id}")
    public ResponseEntity<OrderProduct> update(@PathVariable Integer id, @RequestBody OrderProduct e) {
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
