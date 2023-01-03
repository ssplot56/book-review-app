package com.splot.app.controller;

import com.splot.app.dto.request.ReviewRequestDto;
import com.splot.app.dto.response.ReviewResponseDto;
import com.splot.app.model.Review;
import com.splot.app.service.ReviewService;
import com.splot.app.service.mapper.RequestDtoMapper;
import com.splot.app.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final ResponseDtoMapper<ReviewResponseDto, Review> responseDtoMapper;
    private final RequestDtoMapper<ReviewRequestDto, Review> requestDtoMapper;

    public ReviewController(ReviewService reviewService,
                            ResponseDtoMapper<ReviewResponseDto, Review> responseDtoMapper,
                            RequestDtoMapper<ReviewRequestDto, Review> requestDtoMapper) {
        this.reviewService = reviewService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @PostMapping
    public ReviewResponseDto save(@RequestBody @Valid ReviewRequestDto requestDto) {
        Review review = reviewService.save(requestDtoMapper.mapToModel(requestDto));
        return responseDtoMapper.mapToDto(review);
    }

    @GetMapping
    public List<ReviewResponseDto> findAll() {
        return reviewService.findAll().stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReviewResponseDto findById(@PathVariable Long id) {
        return responseDtoMapper.mapToDto(reviewService.findById(id));
    }

    @GetMapping("/by-user/{id}")
    public List<ReviewResponseDto> findByUser(@PathVariable Long id) {
        return reviewService.findByUser(id).stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-book/{id}")
    public List<ReviewResponseDto> findByBook(@PathVariable Long id) {
        return reviewService.findByBook(id).stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ReviewResponseDto update(@PathVariable Long id,
                                    @RequestBody ReviewRequestDto requestDto) {
        Review review = requestDtoMapper.mapToModel(requestDto);
        review.setId(id);
        return responseDtoMapper.mapToDto(reviewService.save(review));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }
}
