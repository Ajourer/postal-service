package com.github.ajourer.postalservice;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PostalItemRepository extends CrudRepository<PostalItem, Long> {
    public Optional<PostalItem> findById(long id);
}
