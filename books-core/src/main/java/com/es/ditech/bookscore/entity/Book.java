package com.es.ditech.bookscore.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "BOOK", schema = "USER_BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookSequenceGenerator")
    @SequenceGenerator(name = "bookSequenceGenerator", sequenceName = "BOOK_SEQUENCE", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PUBLICATION_DATE", nullable = false)
    private String publicationDate;

    @Column(name = "PRICE", precision = 8, scale = 3)
    private BigDecimal price;

    @Column(name = "TITLE", length = 50)
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "STATUS", length = 1, columnDefinition = "CHAR DEFAULT 'A'")
    private char status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @Column(name = "CREATION_DATE", columnDefinition = "DATE DEFAULT SYSDATE")
    private Date creationDate;
}
