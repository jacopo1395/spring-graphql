package org.jacopocarlini.micrographql.repository;

import org.jacopocarlini.micrographql.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
