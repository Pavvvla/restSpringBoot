package org.example.restspringboot.restspringBoot.rest_example.controller;

import org.example.restspringboot.restspringBoot.rest_example.DAO.DAO;
import org.example.restspringboot.restspringBoot.rest_example.model.ARTICLE;
import java.util.List;

@RestController
public class ArticleController {

    private final DAO<ARTICLE, String> articleDAO;

    @Autowired
    public ArticleController(DAO<ARTICLE, String> articleDAO) {
        this.articleDAO = articleDAO;
    }

    @PostMapping(value = "/article")
    public ResponseEntity<?> create(@RequestBody ARTICLE article) {
        articleDAO.create(article);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/article")
    public ResponseEntity<List<ARTICLE>> read() {
        final List<ARTICLE> article = articleDAO.readAll();

        return article != null &&  !article.isEmpty()
                ? new ResponseEntity<>(article, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/article/{id}")
    public ResponseEntity<ARTICLE> read(@PathVariable(name = "id") int id) {
        final ARTICLE article = articleDAO.read(id);

        return article != null
                ? new ResponseEntity<>(article, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/article/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ARTICLE article) {
        final boolean updated = articleDAO.update(article, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/article/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = articleDAO.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
