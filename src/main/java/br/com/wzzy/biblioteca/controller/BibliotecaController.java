package br.com.wzzy.biblioteca.controller;

import br.com.wzzy.biblioteca.model.LivroModel;
import br.com.wzzy.biblioteca.repository.BibliotecaRepository;
import br.com.wzzy.biblioteca.repository.LivroRepository;
import br.com.wzzy.biblioteca.service.BibliotecaService;
import br.com.wzzy.biblioteca.service.LivroService;
import br.com.wzzy.biblioteca.service.LivroServiceImpl;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/biblioteca")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    @Autowired
    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }
}
