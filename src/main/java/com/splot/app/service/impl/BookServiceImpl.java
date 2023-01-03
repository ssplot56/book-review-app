package com.splot.app.service.impl;

import com.splot.app.model.Book;
import com.splot.app.repository.BookRepository;
import com.splot.app.service.AuthorService;
import com.splot.app.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository repository, AuthorService authorService) {
        this.repository = repository;
        this.authorService = authorService;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> findAllByAuthor(Long authorId) {
        return repository.findBooksByAuthor(authorService.findById(authorId));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
