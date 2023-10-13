package com.github.ajourer.postalservice;

import org.springframework.data.repository.CrudRepository;

public interface PostOfficeRepository extends CrudRepository<PostOffice, Long> {
    public PostOffice findById(long id);
}
