package com.splot.app.service;

import com.splot.app.model.Author;
import com.splot.app.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    Book findById(Long id);

    List<Book> findAll();

    List<Book> findAllByAuthor(Author author);

    void deleteById(Long id);
}
