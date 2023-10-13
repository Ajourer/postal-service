package com.github.ajourer.postalservice;

import org.springframework.data.repository.CrudRepository;

public interface PostalItemRepository extends CrudRepository<PostalItem, Long> {
    public PostalItem findById(long id);
}
