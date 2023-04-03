package com.es.ditech.bookscore.entity.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BookType {

    private Date publicationDate;
    private BigDecimal price;
    private String title;
    private String description;
    private String photo;
    private char status;
    private int categoryId;
    private int authorId;
}
