package com.es.ditech.bookscore.service;

import com.es.ditech.bookscore.dto.AuthorTO;
import com.es.ditech.bookscore.dto.PageResponseTO;


public interface IAuthorService {

    PageResponseTO<AuthorTO> getAllList(int pageIndex, int pageSize);

    PageResponseTO<AuthorTO> getAllActive(int pageIndex, int pageSize, char status);

    AuthorTO getById(Long id);
    AuthorTO update(AuthorTO author);
    AuthorTO delete(Long id);
    AuthorTO insert(Long id);
}
