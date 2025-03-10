package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.dto.LivroDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface LivroService {

    LivroDTO cadastrarLivro(LivroDTO livroDTO);

    LivroDTO buscarLivroId(Long idLivro);

    boolean verificarExistenciaIdLivro(Long idLivro);

    LivroDTO atualizarLivro(LivroDTO livroDTO);

    @Transactional
    void deletarLivroPorId(Long idLivro);

}
