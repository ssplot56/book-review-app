package com.splot.app.service.mapper;

public interface RequestDtoMapper <D, T> {
    T mapToModel(D dto);
}
