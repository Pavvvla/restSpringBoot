package org.example.restspringboot.restspringBoot.rest_example.controller;

import org.example.restspringboot.restspringBoot.rest_example.DAO.DAO;
import org.example.restspringboot.restspringBoot.rest_example.model.PRODUCTS;
import java.util.List;

@RestController
public class ProductsController {
    private final DAO<PRODUCTS, String> productsDAO;

    @Autowired
    public ProductsController(DAO<PRODUCTS, String> productsDAO) {
        this.productsDAO = productsDAO;
    }

    @PostMapping(value = "/products")
    public ResponseEntity<?> create(@RequestBody PRODUCTS products) {
        productsDAO.create(products);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<PRODUCTS>> read() {
        final List<PRODUCTS> products = productsDAO.readAll();

        return products != null &&  !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<PRODUCTS> read(@PathVariable(name = "id") int id) {
        final PRODUCTS products = productsDAO.read(id);

        return products != null
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody PRODUCTS products) {
        final boolean updated = productsDAO.update(products, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = productsDAO.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
