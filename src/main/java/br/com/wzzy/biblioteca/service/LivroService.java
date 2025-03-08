package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.model.LivroModel;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface LivroService {


    LivroModel cadastrarLivro(LivroModel livroModel) throws BadRequestException;

    LivroModel atualizarLivro(LivroModel livroModel) throws BadRequestException;

    LivroModel recuperarLivroPorId(long idLivro);

    List<LivroModel> listarLivro();

    void deletarLivros();

    @Transactional
    void deletarLivroPorIdLivro(Long idLivro);
}
