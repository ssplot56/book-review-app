package com.splot.app.controller;

import com.splot.app.dto.request.AuthorRequestDto;
import com.splot.app.dto.response.AuthorResponseDto;
import com.splot.app.model.Author;
import com.splot.app.service.AuthorService;
import com.splot.app.service.mapper.RequestDtoMapper;
import com.splot.app.service.mapper.ResponseDtoMapper;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final RequestDtoMapper<AuthorRequestDto, Author> requestDtoMapper;
    private final ResponseDtoMapper<AuthorResponseDto, Author> responseDtoMapper;

    public AuthorController(AuthorService authorService,
                            RequestDtoMapper<AuthorRequestDto, Author> requestDtoMapper,
                            ResponseDtoMapper<AuthorResponseDto, Author> responseDtoMapper) {
        this.authorService = authorService;
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping
    public AuthorResponseDto save(@RequestBody @Valid AuthorRequestDto requestDto) {
        Author author = authorService.save(requestDtoMapper.mapToModel(requestDto));
        return responseDtoMapper.mapToDto(author);
    }

    @GetMapping
    public List<AuthorResponseDto> findAll() {
        return authorService.findAll().stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AuthorResponseDto findById(@PathVariable Long id) {
        return responseDtoMapper.mapToDto(authorService.findById(id));
    }

    @PutMapping("/{id}")
    public AuthorResponseDto update(@PathVariable Long id,
                                    @RequestBody @Valid AuthorRequestDto requestDto) {
        Author author = requestDtoMapper.mapToModel(requestDto);
        author.setId(id);
        return responseDtoMapper.mapToDto(authorService.save(author));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.deleteById(id);
    }
}
