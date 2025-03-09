package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.dto.LivroDTO;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface LivroService {
    LivroDTO cadastrarLivro(LivroDTO livroDTO);

    LivroDTO atualizarLivro(LivroDTO livroDTO);


//    LivroModel cadastrarLivro(LivroModel livroModel) throws BadRequestException;
//
//    LivroModel atualizarLivro(LivroModel livroModel) throws BadRequestException;
//
//    LivroModel recuperarLivroPorId(long idLivro);
//
//    List<LivroModel> listarLivro();
//
//    void deletarLivros();
//
//    @Transactional
//    void deletarLivroPorIdLivro(Long idLivro);
}
