package com.aula.desc.resources;

import com.aula.desc.entities.Instrutor;
import com.aula.desc.services.InstrutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

    @RestController
    @RequestMapping(value = "/instrutores")
    @Tag(name = "Instrutores")
    public class InstrutorResource {
        @Autowired
        private InstrutorService service;

        @GetMapping
        @Operation(summary = "Search all instrutores", description = "Search all registered instrutor")
        public ResponseEntity<List<Instrutor>> findAll() {
            List<Instrutor> list = service.findAll();
            return ResponseEntity.ok().body(list);
        }

        @GetMapping("/{id}")
        @Operation(summary = "Find instrutor by id", description = "Search an order based on your id")
        public ResponseEntity<Instrutor> findById(@PathVariable Integer id) {
            Instrutor obj = service.findById(id);
            return ResponseEntity.ok(obj);
        }

        @PostMapping
        @Operation(summary = "Add new instrutor", description = "Add new order")
        public ResponseEntity<Instrutor> insert(@RequestBody Instrutor obj) {
            obj = service.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdInstrutor()).toUri();
            return ResponseEntity.created(uri).body(obj);
        }
        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Delete instrutor by id", description = "Delete an order based on your id")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping(value = "/{id}")
        @Operation(summary = "Update instrutor by id")
        public ResponseEntity<Instrutor> update(@PathVariable Integer id, @RequestBody Instrutor obj){
            obj = service.update(id, obj);
            return ResponseEntity.ok().body(obj);
        }
    }
