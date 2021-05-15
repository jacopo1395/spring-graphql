package org.jacopocarlini.micrographql.service;

import org.jacopocarlini.micrographql.model.Author;
import org.jacopocarlini.micrographql.model.Book;
import org.jacopocarlini.micrographql.repository.AuthorRepository;
import org.jacopocarlini.micrographql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GraphService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;


    public Optional<Book> bookById(Long id) {
        return bookRepository.findById(id);
    }

    public Iterable<Book> books() {
        return bookRepository.findAll();
    }

    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    public Book upsertBook(Book book) {
        return bookRepository.save(book);
    }

    public Author upsertAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Boolean deleteBook(Book book) {
        bookRepository.delete(book);
        return true;
    }

    public Boolean deleteAuthor(Author author) {
        authorRepository.delete(author);
        return true;
    }
}
