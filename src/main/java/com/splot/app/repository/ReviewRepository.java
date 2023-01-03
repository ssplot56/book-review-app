package com.splot.app.repository;

import com.splot.app.model.Book;
import com.splot.app.model.Review;
import com.splot.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByUser(User user);

    List<Review> findReviewsByBook(Book book);
}
