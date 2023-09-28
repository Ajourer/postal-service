package com.github.ajourer.postalservice;

import org.springframework.data.repository.CrudRepository;

public interface PostalItemRepository extends CrudRepository<PostalItem, Long> {
    PostalItem findById(long id);
}
