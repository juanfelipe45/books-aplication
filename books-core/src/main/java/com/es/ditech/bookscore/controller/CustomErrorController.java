package com.es.ditech.bookscore.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");


        if (statusCode == 404) {
            return "Página no encontrada";
        } else if (statusCode == 500) {
            return "Error interno del servidor";
        } else {
            return "Error desconocido";
        }
    }

}
