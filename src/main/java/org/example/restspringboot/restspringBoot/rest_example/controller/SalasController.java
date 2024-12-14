package org.example.restspringboot.restspringBoot.rest_example.controller;

import org.example.restspringboot.restspringBoot.rest_example.DAO.DAO;
import org.example.restspringboot.restspringBoot.rest_example.model.SALAS;
import java.util.List;

@RestController
public class SalasController {
    private final DAO<SALAS, String> salasDAO;

    @Autowired
    public SalasController(DAO<SALAS, String> salasDAO) {
        this.salasDAO = salasDAO;
    }

    @PostMapping(value = "/salas")
    public ResponseEntity<?> create(@RequestBody SALAS salas) {
        salasDAO.create(salas);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/salas")
    public ResponseEntity<List<SALAS>> read() {
        final List<SALAS> salas = salasDAO.readAll();

        return salas != null &&  !salas.isEmpty()
                ? new ResponseEntity<>(salas, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/salas/{id}")
    public ResponseEntity<SALAS> read(@PathVariable(name = "id") int id) {
        final SALAS salas = salasDAO.read(id);

        return salas != null
                ? new ResponseEntity<>(salas, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/salas/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody SALAS salas) {
        final boolean updated = salasDAO.update(salas, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/salas/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = salasDAO.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
