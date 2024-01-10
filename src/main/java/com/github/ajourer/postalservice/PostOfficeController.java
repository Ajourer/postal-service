package com.github.ajourer.postalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post-offices")
@RestController
public class PostOfficeController {
    private final PostOfficeRepository repository;

    public PostOfficeController(
        @Autowired final PostOfficeRepository repository
    ) {
        this.repository = repository;
    }

    @GetMapping("")
    @ResponseBody
    public Iterable<PostOffice> all() {
        return repository.findAll();
    }

    @PostMapping("")
    @ResponseBody
    public PostOffice newPostOffice(
        @RequestBody final PostOffice newPostOffice
    ) {
        return repository.save(newPostOffice);
    }

    @GetMapping("/{postcode}")
    @ResponseBody
    public PostOffice one(@PathVariable("postcode") final int postcode) {
        return repository.findByPostcode(postcode).orElseThrow(() ->
            new java.util.NoSuchElementException("" + postcode)
        );
    }

    @PutMapping("/{postcode}")
    @ResponseBody
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
    @ResponseBody
    public void deletePostOffice(@PathVariable("id") final int id) {
        repository.deleteById(id);
    }
}
