package org.jacopocarlini.micrographql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.jacopocarlini.micrographql.model.Author;
import org.jacopocarlini.micrographql.model.Book;
import org.jacopocarlini.micrographql.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private GraphService graphService;

    public Optional<Book> bookById(Long id) {
        return graphService.bookById(id);
    }

    public Iterable<Book> books() {
        return graphService.books();
    }

    public Iterable<Author> authors() {
        return graphService.authors();
    }
}
