package org.jacopocarlini.micrographql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.jacopocarlini.micrographql.model.Author;
import org.jacopocarlini.micrographql.model.Book;
import org.jacopocarlini.micrographql.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private GraphService graphService;


    public Book upsertBook(Book book) {
        return graphService.upsertBook(book);
    }

    public Author upsertAuthor(Author author) {
        return graphService.upsertAuthor(author);
    }

    public Boolean deleteBook(Book book) {
        return graphService.deleteBook(book);
    }

    public Boolean deleteAuthor(Author author) {
        return graphService.deleteAuthor(author);
    }

}
