package com.splot.app.service.impl;

import com.splot.app.model.Review;
import com.splot.app.repository.ReviewRepository;
import com.splot.app.service.BookService;
import com.splot.app.service.ReviewService;
import com.splot.app.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final UserService userService;
    private final BookService bookService;

    public ReviewServiceImpl(ReviewRepository repository,
                             UserService userService,
                             BookService bookService) {
        this.repository = repository;
        this.userService = userService;
        this.bookService = bookService;
    }

    @Override
    public Review save(Review review) {
        return repository.save(review);
    }

    @Override
    public List<Review> findAll() {
        return repository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Review> findByUser(Long userId) {
        return repository.findReviewsByUser(userService.findById(userId));
    }

    @Override
    public List<Review> findByBook(Long bookId) {
        return repository.findReviewsByBook(bookService.findById(bookId));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
