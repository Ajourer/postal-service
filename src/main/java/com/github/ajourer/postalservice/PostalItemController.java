package com.github.ajourer.postalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/postal-items")
@RestController
public class PostalItemController {
    private final PostalItemRepository repository;

    public PostalItemController(
        @Autowired final PostalItemRepository repository
    ) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Iterable<PostalItem> all() {
        return repository.findAll();
    }

    @PostMapping("/")
    public PostalItem newPostalItem(
        @RequestBody final PostalItem newPostalItem
    ) {
        return repository.save(newPostalItem);
    }

    @GetMapping("/{id}")
    public PostalItem one(@PathVariable("id") final long id) {
        return repository.findById(id).orElseThrow(() ->
            new java.util.NoSuchElementException("" + id)
        );
    }

    @PutMapping("/{id}")
    public PostalItem replacePostalItem(
        @RequestBody PostalItem newPostalItem,
        @PathVariable("id") long id
    ) {
        return repository.findById(id).map(postalItem -> {
            postalItem.setType(newPostalItem.getType());
            postalItem.setPostOffice(newPostalItem.getPostOffice());
            return repository.save(postalItem);
        }).orElseGet(() -> {
            newPostalItem.setId(id);
            return repository.save(newPostalItem);
        });
    }

    @DeleteMapping("/{id}")
    public void deletePostalItem(@PathVariable("id") final long id) {
        repository.deleteById(id);
    }
}
