package com.splot.app.service.impl;

import com.splot.app.model.Author;
import com.splot.app.repository.AuthorRepository;
import com.splot.app.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
