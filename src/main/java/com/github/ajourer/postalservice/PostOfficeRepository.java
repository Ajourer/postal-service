package com.github.ajourer.postalservice;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PostOfficeRepository extends CrudRepository<PostOffice, Integer> {
    public Optional<PostOffice> findById(int id);
}
