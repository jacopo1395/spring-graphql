package org.jacopocarlini.micrographql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.jacopocarlini.micrographql.model.Author;
import org.jacopocarlini.micrographql.model.Book;
import org.jacopocarlini.micrographql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    @Autowired
    private AuthorRepository authorRepository;


    public Optional<Author> getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId());
    }
}
