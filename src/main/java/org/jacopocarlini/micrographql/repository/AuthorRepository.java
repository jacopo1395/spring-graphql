package org.jacopocarlini.micrographql.repository;

import org.jacopocarlini.micrographql.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
