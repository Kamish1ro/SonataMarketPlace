package com.sonata.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
/**
 * @author Kam1shiro
 * */
@RestController
public class ClothesController {
    private final ClothesService clothesService;

    @Autowired
    public ClothesController(ClothesService clothesService){
        this.clothesService = clothesService;
    }
    /**
     * @param clothes - объект клаасса Clothes, через него проверяется, корректны ли введённые данные.
     *                Если цена(price) или количество(quantity) меньши нуля, то выдается ошибка 400 badRequest.
     * */
    @PostMapping(value = "/clothes")
    public ResponseEntity<Clothes> create(@Valid @RequestBody Clothes clothes){
        if (clothes.getPrice() < 0) {
            return ResponseEntity.badRequest().body(null);
        }
        if (clothes.getQuantity() < 0) {
            return ResponseEntity.badRequest().body(null);
        }
        clothesService.create(clothes);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/clothes")
    public ResponseEntity<List<Clothes>> read(){
        final List<Clothes> clothes = clothesService.readAll();

        return clothes != null && !clothes.isEmpty()
                ? new ResponseEntity<>(clothes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/clothes/{id}")
    public ResponseEntity<Clothes> read(@PathVariable(name = "id") int id) {
        final Clothes clothes = clothesService.read(id);

        return clothes != null
                ? new ResponseEntity<>(clothes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/clothes/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Clothes clothes) {
        final boolean updated = clothesService.update(clothes, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clothes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = clothesService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
