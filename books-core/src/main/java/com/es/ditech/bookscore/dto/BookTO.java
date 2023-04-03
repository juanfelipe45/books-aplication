package com.es.ditech.bookscore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookTO {
    private LocalDate publicationDate;
    private BigDecimal price;
    private String title;
    private String description;
    private String photo;
    private String status;
    private CategoryTO category;
    private AuthorTO author;
}
