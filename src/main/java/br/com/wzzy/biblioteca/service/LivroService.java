package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.dto.LivroDTO;
import br.com.wzzy.biblioteca.model.entity.Livro;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface LivroService {

    LivroDTO cadastrarLivro(LivroDTO livroDTO);

    List<Livro> recuperarLivroPorIdLivro(Long idLivro);

    boolean verificarExistenciaIdLivro(Long idLivro);

    LivroDTO atualizarLivro(LivroDTO livroDTO);

    @Transactional
    void deletarLivroPorId(Long idLivro);

    @Transactional
    void deletarTodos();

}
