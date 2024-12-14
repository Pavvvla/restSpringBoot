package org.example.restspringboot.restspringBoot.rest_example.controller;

import org.example.restspringboot.restspringBoot.rest_example.DAO.DAO;
import org.example.restspringboot.restspringBoot.rest_example.model.SKIRTS;
import java.util.List;

@RestController
public class SkirtsController {
    private final DAO<SKIRTS, String> skirtsDAO;

    @Autowired
    public SkirtsController(DAO<SKIRTS, String> skirtsDAO) {
        this.skirtsDAO = skirtsDAO;
    }

    @PostMapping(value = "/skirts")
    public ResponseEntity<?> create(@RequestBody SKIRTS skirts) {
        skirtsDAO.create(skirts);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/skirts")
    public ResponseEntity<List<SKIRTS>> read() {
        final List<SKIRTS> skirts = skirtsDAO.readAll();

        return skirts != null &&  !skirts.isEmpty()
                ? new ResponseEntity<>(skirts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/skirts/{id}")
    public ResponseEntity<SKIRTS> read(@PathVariable(name = "id") int id) {
        final SKIRTS skirts = skirtsDAO.read(id);

        return skirts != null
                ? new ResponseEntity<>(skirts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/skirts/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody SKIRTS skirts) {
        final boolean updated = skirtsDAO.update(skirts, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/skirts/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = skirtsDAO.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
