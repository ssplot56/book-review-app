package com.splot.app.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String country;
}
