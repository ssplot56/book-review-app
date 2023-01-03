package com.splot.app.service.mapper;

import com.splot.app.dto.request.ReviewRequestDto;
import com.splot.app.dto.response.ReviewResponseDto;
import com.splot.app.model.Review;
import com.splot.app.service.BookService;
import com.splot.app.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper implements RequestDtoMapper<ReviewRequestDto, Review>,
        ResponseDtoMapper<ReviewResponseDto, Review> {
    private final UserService userService;
    private final BookService bookService;

    public ReviewMapper(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @Override
    public Review mapToModel(ReviewRequestDto dto) {
        Review review = new Review();
        review.setUser(userService.findById(dto.getUserId()));
        review.setBook(bookService.findById(dto.getBookId()));
        review.setDescription(dto.getDescription());
        return review;
    }

    @Override
    public ReviewResponseDto mapToDto(Review review) {
        ReviewResponseDto dto = new ReviewResponseDto();
        dto.setId(review.getId());
        dto.setUserId(review.getUser().getId());
        dto.setBookId(review.getBook().getId());
        dto.setDescription(review.getDescription());
        return dto;
    }
}
