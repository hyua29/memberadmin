package com.example.demo.controllers;


import com.example.demo.models.IsDbModel;
import com.example.demo.models.Mergeable;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiParam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Provide a generic Crud controller
 * @param <T> Database model
 * @param <S> Subclass of CrudRepository
 * @param <V> Type of model id e.g. String, Integer, Long
 */
public abstract class BaseRestController<T extends IsDbModel<V> & Mergeable, S extends CrudRepository<T, V>, V> {

    protected S repo;

    public BaseRestController(S repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public List<T> findAll() {
        return  Lists.newArrayList(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@ApiParam(value = "Model ID", required = true) @PathVariable V id) {
        Optional<T> model = repo.findById(id);
        if (!model.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(model.get());
    }

    @PostMapping("/")
    public ResponseEntity<T> create(@ApiParam(value = "Create model", required = true) @Valid @RequestBody T t) {
        return ResponseEntity.ok(repo.save(t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@ApiParam(value = "Model ID", required = true) @PathVariable V id) {
        Optional<T> model = repo.findById(id);
        if (!model.isPresent()) return ResponseEntity.notFound().build();

        repo.deleteById(id);
        return ResponseEntity.ok().body("Object deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@ApiParam(value = "Model ID", required = true) @PathVariable V id,
                                    @ApiParam(value = "Update model", required = true) @Valid @RequestBody T t) {
        Optional<T> model = repo.findById(id);
        if (!model.isPresent()) return ResponseEntity.notFound().build();

        t.setId(id);
        T updatedModel = repo.save(t);
        return ResponseEntity.ok().body(updatedModel);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<T> partialUpdate(@ApiParam(value = "Model ID", required = true) @PathVariable V id,
                                           @ApiParam(value = "Update partial model", required = true) @Valid @RequestBody T t) {
        Optional<T> model = repo.findById(id);
        if (!model.isPresent()) return ResponseEntity.notFound().build();

        T existingModel = model.get();
        existingModel.mergeWith(t);

        T updatedModel = repo.save(existingModel);
        return ResponseEntity.ok().body(updatedModel);
    }

}
