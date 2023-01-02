package com.splot.app.service.mapper;

import com.splot.app.dto.request.BookRequestDto;
import com.splot.app.dto.response.BookResponseDto;
import com.splot.app.model.Book;
import com.splot.app.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements RequestDtoMapper<BookRequestDto, Book>,
        ResponseDtoMapper<BookResponseDto, Book> {
    private final AuthorService authorService;

    public BookMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public Book mapToModel(BookRequestDto dto) {
        Book book = new Book();
        book.setName(dto.getName());
        book.setDescription(dto.getDescription());
        book.setYear(dto.getYear());
        book.setAuthor(authorService.findById(dto.getAuthorId()));
        return book;
    }

    @Override
    public BookResponseDto mapToDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setDescription(book.getDescription());
        dto.setYear(book.getYear());
        dto.setAuthorId(book.getAuthor().getId());
        return dto;
    }
}
