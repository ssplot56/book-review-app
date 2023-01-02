package com.splot.app.service.mapper;

import com.splot.app.dto.request.AuthorRequestDto;
import com.splot.app.dto.response.AuthorResponseDto;
import com.splot.app.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements RequestDtoMapper<AuthorRequestDto, Author>,
        ResponseDtoMapper<AuthorResponseDto, Author> {
    @Override
    public Author mapToModel(AuthorRequestDto dto) {
        Author author = new Author();
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setCountry(dto.getCountry());
        return author;
    }

    @Override
    public AuthorResponseDto mapToDto(Author author) {
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setId(author.getId());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setCountry(author.getCountry());
        return dto;
    }
}
