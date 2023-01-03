package com.splot.app.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponseDto {
    private Long id;
    private Long userId;
    private Long bookId;
    private String description;
}
