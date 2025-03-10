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
import java.util.stream.Collectors;

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


        Livro livro = LivroMapper.INSTANCE.paraLivro(livroDTO);

        Livro livroSalvo = livroRepository.save(livro);

        return LivroMapper.INSTANCE.paraLivroDTO(livroSalvo);
    }

    @Override
    public LivroDTO buscarLivroId(Long idLivro) {
        Livro livro = livroRepository.findByIdLivro(idLivro)
                .orElseThrow(() -> new LivroNaoEncontradoException("Livro com id " + idLivro + " não encontrado!"));
        return LivroMapper.INSTANCE.paraLivroDTO(livro);
    }

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

        /*
        * Executa uma função que chama um verficiador de ID para
        * garantir que o livro que será atualizado existe, ou não.*/
        buscarLivroId(livroDTO.getIdLivroDTO());

        /*
        * Deixa como retorno a chamada ao método de cadastro de livro
        * para que, caso o livro existe, ele possa usar dos mesmos
        * recursos que são utilizados para cadastrar o livro */
        return livroDTO = cadastrarLivro(livroDTO);

    }

    @Transactional
    @Override
    public void deletarLivroPorId(Long idLivro){
        livroRepository.deleteByIdLivro(idLivro);
    }

}