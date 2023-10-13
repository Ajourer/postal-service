package com.github.ajourer.postalservice;

import org.springframework.data.repository.CrudRepository;

public interface PostOfficeRepository extends CrudRepository<PostOffice, Integer> {
    public PostOffice findById(int id);
}
