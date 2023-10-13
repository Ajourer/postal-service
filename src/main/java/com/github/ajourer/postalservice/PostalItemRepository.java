package com.github.ajourer.postalservice;

import org.springframework.data.repository.ListCrudRepository;

public interface PostalItemRepository extends ListCrudRepository<PostalItem, Long> {
    public PostalItem findById(long id);
}
