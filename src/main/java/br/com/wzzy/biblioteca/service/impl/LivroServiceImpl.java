package br.com.wzzy.biblioteca.service.impl;

import br.com.wzzy.biblioteca.dto.LivroDTO;
import br.com.wzzy.biblioteca.exception.LivroCadastradoException;
import br.com.wzzy.biblioteca.exception.LivroNaoEncontradoException;
import br.com.wzzy.biblioteca.mapper.LivroMapper;
import br.com.wzzy.biblioteca.model.entity.Livro;

import br.com.wzzy.biblioteca.repository.LivroRepository;
import br.com.wzzy.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean encontrarIdLivro(Long idLivro) {

        boolean livroEncontraro = livroRepository.existsById(idLivro);
        if (!livroEncontraro) {
            throw new LivroNaoEncontradoException("Livro com id " + idLivro + " não encontrado!");
        }
        return livroEncontraro;
    }

    @Override
    public LivroDTO atualizarLivro(LivroDTO livroDTO) {

        boolean encontrarLivro = encontrarIdLivro(livroDTO.getIdLivro());

        if (encontrarLivro) {
            throw new LivroCadastradoException("Livro já cadastrado!");
        }

        return livroDTO = cadastrarLivro(livroDTO);
//        Livro livro = LivroMapper.paraEntidadeLivro(livroDTO);
//        Livro livroSalvo = livroRepository.save(livro);
//        return LivroMapper.paraLivroDTO(livroSalvo);
    }

//    public LivroModel tratativarParaAtualizarLivro(LivroModel livroModel) throws BadRequestException {
//        return livroRepository.save(livroModel);
//    }
//
//    public ResponseEntity<LivroModel> tratativarParaCadastrarLivro(LivroModel livroModel) {
//        Optional<LivroModel> livroJaCadastrado = livroRepository.findByTituloLivroAndAutorAndCategoria(
//                livroModel.getTituloLivro().trim(),
//                livroModel.getAutor().trim(),
//                livroModel.getCategoria().trim()
//        );
//
//        if (livroJaCadastrado.isPresent()) {
//            throw new LivroCadastradoException("Livro já cadastrado!");
//        }
//
//        LivroModel livroSalvo = livroRepository.save(livroModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
//    }
//
//
//    @Override
//    public LivroModel cadastrarLivro(LivroModel livroModel) throws BadRequestException {
//        return tratativarParaCadastrarLivro(livroModel).getBody();
//    }
//
//    @Override
//    public LivroModel atualizarLivro(LivroModel livroModel) throws BadRequestException {
//        return tratativarParaAtualizarLivro(livroModel);
//    }
//
//    @Override
//    public LivroModel recuperarLivroPorId(long idLivro) {
//        return livroRepository.findByIdLivro(idLivro);
//    }
//
//    @Override
//    public List<LivroModel> listarLivro(){
//        return livroRepository.findAll();
//    }
//
//    @Override
//    public void deletarLivros(){
//        livroRepository.deleteAll();
//    }
//
//    @Override
//    @Transactional
//    public void deletarLivroPorIdLivro(Long idLivro){
//        if (livroRepository.existsByIdLivro(idLivro)) {
//            livroRepository.deleteByIdLivro(idLivro);
//        } else {
//            throw new RuntimeException("Livro com id " + idLivro + " não encontrado");
//        }
//    }
}