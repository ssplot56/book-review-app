package com.splot.app.service.impl;

import com.splot.app.model.Author;
import com.splot.app.model.Book;
import com.splot.app.repository.BookRepository;
import com.splot.app.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
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
    public List<Book> findAllByAuthor(Author author) {
        return repository.findBooksByAuthor(author);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
