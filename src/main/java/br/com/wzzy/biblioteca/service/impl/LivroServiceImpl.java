package br.com.wzzy.biblioteca.service.impl;

import br.com.wzzy.biblioteca.dto.LivroDTO;
import br.com.wzzy.biblioteca.exception.LivroCadastradoException;
import br.com.wzzy.biblioteca.exception.LivroNaoEncontradoException;
import br.com.wzzy.biblioteca.mapper.LivroMapper;
import br.com.wzzy.biblioteca.model.entity.Livro;

import br.com.wzzy.biblioteca.repository.LivroRepository;
import br.com.wzzy.biblioteca.service.LivroService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroServiceImpl(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public LivroDTO cadastrarLivro(LivroDTO livroDTO) {
        if (livroDTO.getAutor().isEmpty() ||
                livroDTO.getTitulo().isEmpty() ||
                livroDTO.getStatusLivroEnum() == null ||
                livroDTO.getCategoriaLivroEnum() == null ) {
            throw new LivroCadastradoException("Dados incorretos!");
        }

        Livro livro = LivroMapper.paraEntidadeLivro(livroDTO);
        Livro livroSalvo = livroRepository.save(livro);
        return LivroMapper.paraLivroDTO(livroSalvo);
    }

    @Override
    public List<Livro> recuperarLivroPorIdLivro(Long idLivro) {

        return livroRepository.findByIdLivro(idLivro);
    }

    @Override
    public boolean verificarExistenciaIdLivro(Long idLivro) {

        boolean livroEncontrado = livroRepository.existsById(idLivro);
        if (livroEncontrado) {
            return livroEncontrado;
        } else {
            throw new LivroNaoEncontradoException("Livro com id " + idLivro + " não encontrado!");

        }
    }


    @Override
    public LivroDTO atualizarLivro(LivroDTO livroDTO) {

        boolean verificarIdLivro = verificarExistenciaIdLivro(livroDTO.getIdLivro());

//        List<Livro> encontrarLivro = recuperarLivroPorIdLivro(livroDTO.getIdLivro());

        return livroDTO = cadastrarLivro(livroDTO);

    }

    @Transactional
    @Override
    public void deletarLivroPorId(Long idLivro){
        livroRepository.deleteByIdLivro(idLivro);
    }

    @Transactional
    @Override
    public void deletarTodos(){
        livroRepository.deleteAll();
    }
//
//    @Override
//    public Livro livroPorId(Long idLivro){
//
//        return recu;
//    }

}