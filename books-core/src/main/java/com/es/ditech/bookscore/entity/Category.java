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
@Table(name = "CATEGORY", schema = "USER_BOOK")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequenceGenerator")
    @SequenceGenerator(name = "categorySequenceGenerator", sequenceName = "CATEGORY_SEQUENCE", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "STATUS", length = 1, columnDefinition = "CHAR DEFAULT 'A'")
    private char status;

    @Column(name = "CREATION_DATE", columnDefinition = "DATE DEFAULT SYSDATE")
    private Date creationDate;
}
