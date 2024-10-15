package com.javarush.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PageDTO<T> {
    private List<T> content;
    private long totalElements;
    private int totalPages;
    private int pageSize;
    private int pageNumber;
    private int last;
    private int first;

    public PageDTO(Page<T> page, Pageable pageable) {
        this.content = page.getContent();
        this.pageSize = pageable.getPageSize();
        this.pageNumber = pageable.getPageNumber();
        this.totalElements = (int) page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }

    public PageDTO(List<T> data, Pageable pageable, Page info) {
        this.last = info.getTotalPages();
        this.first = 0;
        this.content = data;
        this.pageSize = pageable.getPageSize();
        this.pageNumber = pageable.getPageNumber();
        this.totalElements = info.getTotalElements();
        this.totalPages = info.getTotalPages();
    }
}
