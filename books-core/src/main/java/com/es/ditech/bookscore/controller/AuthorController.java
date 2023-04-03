package com.es.ditech.bookscore.controller;

import com.es.ditech.bookscore.dto.AuthorTO;
import com.es.ditech.bookscore.dto.GeneralResponseTO;
import com.es.ditech.bookscore.dto.HeaderResponseTO;
import com.es.ditech.bookscore.dto.PageResponseTO;
import com.es.ditech.bookscore.service.IAuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.es.ditech.bookscore.util.constants.UrlMappingConstant.*;

@RestController
@RequestMapping(value = VERSION_1 + AUTHOR)
public class AuthorController {

    private  final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<GeneralResponseTO<PageResponseTO<AuthorTO>>> getAll(
            @RequestParam int pageIndex,
            @RequestParam int pageSize
    ) {
        return new ResponseEntity<>(
            new GeneralResponseTO<>(
                    new HeaderResponseTO(HttpStatus.OK.value(), ""),
                    this.authorService.getAllList(pageIndex, pageSize)
            ),
            HttpStatus.OK
        );
    }

    @GetMapping(path = "/status")
    public ResponseEntity<GeneralResponseTO<PageResponseTO<AuthorTO>>> getAllByStatus(
            @RequestParam int pageIndex,
            @RequestParam int pageSize,
            @RequestParam char status
    ) {
        return new ResponseEntity<>(
                new GeneralResponseTO<>(
                        new HeaderResponseTO(HttpStatus.OK.value(), ""),
                        this.authorService.getAllActive(pageIndex, pageSize, status)
                ),
                HttpStatus.OK
        );
    }
}
