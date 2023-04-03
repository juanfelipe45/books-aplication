package com.es.ditech.bookscore.repository;

import com.es.ditech.bookscore.entity.Author;
import com.es.ditech.bookscore.entity.type.AuthorType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    Page<Author> findByStatus(Pageable pageable, char status);

    @Procedure(name = "CREATE_AUTHOR")
    void createAuthor(@Param("p_author") AuthorType author,
                      @Param("p_code") Integer code,
                      @Param("p_response") String response);
}
