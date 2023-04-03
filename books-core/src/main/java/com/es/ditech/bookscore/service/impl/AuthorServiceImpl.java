package com.es.ditech.bookscore.service.impl;

import com.es.ditech.bookscore.dto.AuthorTO;
import com.es.ditech.bookscore.dto.PageResponseTO;
import com.es.ditech.bookscore.entity.Author;
import com.es.ditech.bookscore.repository.AuthorRepository;
import com.es.ditech.bookscore.service.IAuthorService;
import com.es.ditech.bookscore.util.EntityDtoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements IAuthorService {

    private final AuthorRepository authorRepository;
    private final EntityDtoMapper mapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, EntityDtoMapper mapper) {
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    @Override
    public PageResponseTO<AuthorTO> getAllList(int pageIndex, int pageSize) {
        PageResponseTO<AuthorTO> pageResponse = new PageResponseTO<>();
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<Author> authors = this.authorRepository.findAll(pageable);

        pageResponse.setData(
                authors.stream()
                    .map(author -> mapper.toDto(author, AuthorTO.class))
                    .collect(Collectors.toList())
        );
        pageResponse.setCount(authors.getTotalElements());

        return pageResponse;
    }

    @Override
    public PageResponseTO<AuthorTO> getAllActive(int pageIndex, int pageSize, char status) {
        PageResponseTO<AuthorTO> pageResponse = new PageResponseTO<>();
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<Author> authors = this.authorRepository.findByStatus(pageable, status);

        pageResponse.setData(
                authors.stream()
                        .map(author -> mapper.toDto(author, AuthorTO.class))
                        .collect(Collectors.toList())
        );
        pageResponse.setCount(authors.getTotalElements());

        return pageResponse;
    }

    @Override
    public AuthorTO getById(Long id) {
        return null;
    }

    @Override
    public AuthorTO update(AuthorTO author) {
        return null;
    }

    @Override
    public AuthorTO delete(Long id) {
        return null;
    }

    @Override
    public AuthorTO insert(Long id) {
        return null;
    }
}
