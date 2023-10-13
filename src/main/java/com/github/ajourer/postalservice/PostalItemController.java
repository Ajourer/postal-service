package com.github.ajourer.postalservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostalItemController {
    private final PostalItemRepository repository;

    public PostalItemController(
        @Autowired final PostalItemRepository repository
    ) {
      this.repository = repository;
    }

    @GetMapping("/postal-items")
    public List<PostalItem> all() {
        return repository.findAll();
    }

    @PostMapping("/postal-items")
    public PostalItem newPostalItem(
        @RequestBody final PostalItem newPostalItem
    ) {
        return repository.save(newPostalItem);
    }

    @GetMapping("/postal-items/{id}")
    public PostalItem one(@PathVariable final long id) {
        return repository.findById(id).orElseThrow(() ->
            new PostalItemNotFoundException(id)
        );
    }

    /* @PutMapping("/postal-items/{id}")
    public PostalItem replacePostalItem(
        @RequestBody PostalItem newPostalItem,
        @PathVariable Long id
    ) {
        return repository.findById(id).map(postalItem -> {
            postalItem.setName(newPostalItem.getName());
            postalItem.setRole(newPostalItem.getRole());
            return repository.save(postalItem);
        }).orElseGet(() -> {
            newPostalItem.setId(id);
            return repository.save(newPostalItem);
        });
    } */

    @DeleteMapping("/postal-items/{id}")
    public void deletePostalItem(@PathVariable final long id) {
        repository.deleteById(id);
    }
}
