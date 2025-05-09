package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
    var optionalClient = clientService.findById(id);
    if (optionalClient.isPresent()) {
        return ResponseEntity.ok(optionalClient.get());
    } else {
        return ResponseEntity.status(404).body(Map.of("error", "Cliente no encontrado"));
    }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Client client) {
        Client saved = clientService.save(client);
        return ResponseEntity.ok(Map.of(
                "message", "Cliente creado correctamente",
                "client", saved
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.findById(id)
                .map(existing -> {
                    client.setId(id);
                    Client updated = clientService.save(client);
                    return ResponseEntity.ok(Map.of(
                            "message", "Cliente actualizado correctamente",
                            "client", updated
                    ));
                })
                .orElseGet(() -> ResponseEntity.status(404).body(Map.of("error", "Cliente no encontrado")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return clientService.findById(id)
                .map(client -> {
                    clientService.delete(id);
                    return ResponseEntity.ok(Map.of("message", "Cliente eliminado correctamente"));
                })
                .orElseGet(() -> ResponseEntity.status(404).body(Map.of("error", "Cliente no encontrado")));
    }
}
