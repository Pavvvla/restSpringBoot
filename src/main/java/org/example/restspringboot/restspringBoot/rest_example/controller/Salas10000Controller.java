package org.example.restspringboot.restspringBoot.rest_example.controller;

import org.example.restspringboot.restspringBoot.rest_example.DAO.DAO;
import org.example.restspringboot.restspringBoot.rest_example.model.SALAS10000;
import java.util.List;

@RestController
public class Salas10000Controller {
    private final DAO<SALAS10000, String> salas10000DAO;

    @Autowired
    public Salas10000Controller(DAO<SALAS10000, String> salas10000DAO) {
        this.salas10000DAO = salas10000DAO;
    }

    @PostMapping(value = "/salas10000")
    public ResponseEntity<?> create(@RequestBody SALAS10000 salas10000) {
        salas10000DAO.create(salas10000);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/salas10000")
    public ResponseEntity<List<SALAS10000>> read() {
        final List<SALAS10000> salas10000 = salas10000DAO.readAll();

        return salas10000 != null &&  !salas10000.isEmpty()
                ? new ResponseEntity<>(salas10000, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/salas10000/{id}")
    public ResponseEntity<SALAS10000> read(@PathVariable(name = "id") int id) {
        final SALAS10000 salas10000 = salas10000DAO.read(id);

        return salas10000 != null
                ? new ResponseEntity<>(salas10000, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/salas10000/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody SALAS10000 salas10000) {
        final boolean updated = salas10000DAO.update(salas10000, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/salas10000/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = salas10000DAO.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
