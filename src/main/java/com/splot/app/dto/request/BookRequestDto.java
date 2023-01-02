package com.splot.app.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String description;
    private Integer year;
    private Long authorId;
}
