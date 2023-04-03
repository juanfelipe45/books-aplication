package com.es.ditech.bookscore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuthorTO {
    private String name;
    private LocalDate birthday;
    private String photo;
    private String status;

    private List<BookTO> books;
}
