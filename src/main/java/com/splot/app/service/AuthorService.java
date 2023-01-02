package com.splot.app.service;

import com.splot.app.model.Author;
import java.util.List;

public interface AuthorService {
    Author save(Author author);

    Author findById(Long id);

    List<Author> findAll();

    void deleteById(Long id);
}
