package com.splot.app.service;

import com.splot.app.model.Review;
import java.util.List;

public interface ReviewService {
    Review save(Review review);

    List<Review> findAll();

    Review findById(Long id);

    List<Review> findByUser(Long userId);

    List<Review> findByBook(Long bookId);

    void delete(Long id);
}
