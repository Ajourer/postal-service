package com.github.ajourer.postalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post-offices")
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

    @GetMapping("/{postcode}")
    public PostOffice one(@PathVariable("postcode") final int postcode) {
        return repository.findByPostcode(postcode).orElseThrow(() ->
            new java.util.NoSuchElementException("" + postcode)
        );
    }

    @PutMapping("/{postcode}")
    public PostOffice replacePostOffice(
        @RequestBody PostOffice newPostOffice,
        @PathVariable("postcode") int postcode
    ) {
        return repository.findByPostcode(postcode).map(PostOffice -> {
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
