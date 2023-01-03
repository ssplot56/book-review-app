package com.splot.app.controller;

import com.splot.app.dto.request.BookRequestDto;
import com.splot.app.dto.response.BookResponseDto;
import com.splot.app.model.Book;
import com.splot.app.service.BookService;
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
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final ResponseDtoMapper<BookResponseDto, Book> responseDtoMapper;
    private final RequestDtoMapper<BookRequestDto, Book> requestDtoMapper;

    public BookController(BookService bookService,
                          ResponseDtoMapper<BookResponseDto, Book> responseDtoMapper,
                          RequestDtoMapper<BookRequestDto, Book> requestDtoMapper) {
        this.bookService = bookService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @PostMapping
    public BookResponseDto save(@RequestBody @Valid BookRequestDto requestDto) {
        Book book = bookService.save(requestDtoMapper.mapToModel(requestDto));
        return responseDtoMapper.mapToDto(book);
    }

    @GetMapping
    public List<BookResponseDto> findAll() {
        return bookService.findAll().stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookResponseDto findById(@PathVariable Long id) {
        return responseDtoMapper.mapToDto(bookService.findById(id));
    }

    @GetMapping("/authors/{id}")
    public List<BookResponseDto> findByAuthor(@PathVariable Long id) {
        return bookService.findAllByAuthor(id).stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id,
                                  @RequestBody @Valid BookRequestDto requestDto) {
        Book book = requestDtoMapper.mapToModel(requestDto);
        book.setId(id);
        return responseDtoMapper.mapToDto(bookService.save(book));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
