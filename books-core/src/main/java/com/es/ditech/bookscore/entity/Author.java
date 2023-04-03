package com.es.ditech.bookscore.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "AUTHOR", schema = "USER_BOOK")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorSequenceGenerator")
    @SequenceGenerator(name = "authorSequenceGenerator", sequenceName = "AUTHOR_SEQUENCE", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "PHOTO")
    private String photo;

    @Column(name = "STATUS", length = 1, columnDefinition = "CHAR DEFAULT 'A'")
    private char status;

    @Column(name = "CREATION_DATE", columnDefinition = "DATE DEFAULT SYSDATE")
    private Date creationDate;
}
