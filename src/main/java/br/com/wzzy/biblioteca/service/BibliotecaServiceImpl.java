package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaServiceImpl implements BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    @Autowired
    public BibliotecaServiceImpl(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }
}
