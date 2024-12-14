package org.example.restspringboot.restspringBoot.rest_example.controller;

import org.example.restspringboot.restspringBoot.rest_example.DAO.DAO;
import org.example.restspringboot.restspringBoot.rest_example.model.DRESS;
import java.util.List;

@RestController
public class DressController {
    private final DAO<DRESS, String> dressDAO;

    @Autowired
    public DressController(DAO<DRESS, String> dressDAO) {
        this.dressDAO = dressDAO;
    }

    @PostMapping(value = "/dress")
    public ResponseEntity<?> create(@RequestBody DRESS dress) {
        dressDAO.create(dress);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/dress")
    public ResponseEntity<List<DRESS>> read() {
        final List<DRESS> dress = dressDAO.readAll();

        return dress != null &&  !dress.isEmpty()
                ? new ResponseEntity<>(dress, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/dress/{id}")
    public ResponseEntity<DRESS> read(@PathVariable(name = "id") int id) {
        final DRESS dress = dressDAO.read(id);

        return dress != null
                ? new ResponseEntity<>(dress, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/dress/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody DRESS dress) {
        final boolean updated = dressDAO.update(dress, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/dress/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = dressDAO.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
