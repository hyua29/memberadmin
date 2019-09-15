package com.example.demo.controllers;


import com.example.demo.models.IsDbModel;
import javassist.compiler.ast.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Optional;

public abstract class BaseRestController<T extends IsDbModel<V>, S extends CrudRepository<T, V>, V> {

    protected S repo;

    public BaseRestController(S repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public Iterable<T> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable V id) {
        Optional<T> model = repo.findById(id);
        if (!model.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(model.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable V id) {
        Optional<T> model = repo.findById(id);
        if (!model.isPresent()) return ResponseEntity.notFound().build();

        repo.deleteById(id);
        return ResponseEntity.ok().body("Object deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable V id, @RequestBody T t) {
        Optional<T> model = repo.findById(id);
        if (!model.isPresent()) return ResponseEntity.notFound().build();

        t.setId(id);
        T updatedModel = repo.save(t);
        return ResponseEntity.ok().body(updatedModel);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<T> partialUpdate(@PathVariable V id, @RequestBody T t) {
        Optional<T> model = repo.findById(id);
        if (!model.isPresent()) return ResponseEntity.notFound().build();

        T existingModel = model.get();
        System.out.println("-00000000000");
        System.out.println(existingModel);
        System.out.println(t);
        existingModel.mergeWith(t);

        T updatedModel = repo.save(existingModel);
        return ResponseEntity.ok().body(updatedModel);
    }

}
