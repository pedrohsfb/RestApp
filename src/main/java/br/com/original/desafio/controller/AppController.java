package br.com.original.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping
public class AppController {

    @GetMapping("/")
    public void redir(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8080/index.xhtml");
    }

    @GetMapping("/test")
    public String test() {
        return "RestApp V1 running!!!";
    }

}
