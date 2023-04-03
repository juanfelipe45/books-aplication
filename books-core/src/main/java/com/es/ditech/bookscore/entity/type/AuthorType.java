package com.es.ditech.bookscore.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AuthorType {

    private String name;
    private LocalDate birthday;
    private String photo;
    private String status;
    private List<BookType> books;
}
