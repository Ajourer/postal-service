package com.github.ajourer.postalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post-office")
@RestController
public class PostOfficeController {
    private final PostOfficeRepository repository;

    public PostOfficeController(
        @Autowired final PostOfficeRepository repository
    ) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Iterable<PostOffice> all() {
        return repository.findAll();
    }

    @PostMapping("/")
    public PostOffice newPostOffice(
        @RequestBody final PostOffice newPostOffice
    ) {
        return repository.save(newPostOffice);
    }

    @GetMapping("/{id}")
    public PostOffice one(@PathVariable("id") final int id) {
        return repository.findById(id).orElseThrow(() ->
            new java.util.NoSuchElementException("" + id)
        );
    }

    @PutMapping("/{postcode}")
    public PostOffice replacePostOffice(
        @RequestBody PostOffice newPostOffice,
        @PathVariable("postcode") Integer postcode
    ) {
        return repository.findById(postcode).map(PostOffice -> {
            PostOffice.setName(newPostOffice.getName());
            PostOffice.setAddress(newPostOffice.getAddress());
            return repository.save(PostOffice);
        }).orElseGet(() -> {
            newPostOffice.setPostcode(postcode);
            return repository.save(newPostOffice);
        });
    }

    @DeleteMapping("/{id}")
    public void deletePostOffice(@PathVariable("id") final int id) {
        repository.deleteById(id);
    }
}
