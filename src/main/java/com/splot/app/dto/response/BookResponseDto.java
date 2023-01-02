package com.splot.app.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookResponseDto {
    private Long id;
    private String name;
    private String description;
    private Integer year;
    private Long authorId;
}
