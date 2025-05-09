package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        var optionalOrder = orderService.findById(id);
        if (optionalOrder.isPresent()) {
            return ResponseEntity.ok(optionalOrder.get());
        } else {
            return ResponseEntity.status(404).body(Map.of("error", "Pedido no encontrado"));
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Order order) {
        Order saved = orderService.save(order);
        return ResponseEntity.ok(Map.of(
                "message", "Pedido creado correctamente",
                "order", saved
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Order order) {
        var optionalOrder = orderService.findById(id);
        if (optionalOrder.isPresent()) {
            order.setId(id);
            Order updated = orderService.save(order);
            return ResponseEntity.ok(Map.of(
                    "message", "Pedido actualizado correctamente",
                    "order", updated
            ));
        } else {
            return ResponseEntity.status(404).body(Map.of("error", "Pedido no encontrado"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        var optionalOrder = orderService.findById(id);
        if (optionalOrder.isPresent()) {
            orderService.delete(id);
            return ResponseEntity.ok(Map.of("message", "Pedido eliminado correctamente"));
        } else {
            return ResponseEntity.status(404).body(Map.of("error", "Pedido no encontrado"));
        }
    }
}
