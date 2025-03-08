package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.exception.LivroCadastradoException;
import br.com.wzzy.biblioteca.model.LivroModel;
import br.com.wzzy.biblioteca.repository.BibliotecaRepository;
import br.com.wzzy.biblioteca.repository.ClienteRepository;
import br.com.wzzy.biblioteca.repository.FuncionarioRepository;
import br.com.wzzy.biblioteca.repository.LivroRepository;
import br.com.wzzy.biblioteca.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    private final BibliotecaRepository bibliotecaRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public LivroServiceImpl(BibliotecaRepository bibliotecaRepository,
                            ClienteRepository clienteRepository,
                            FuncionarioRepository funcionarioRepository,
                            LivroRepository livroRepository,
                            UsuarioRepository usuarioRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public LivroModel tratativarParaAtualizarLivro(LivroModel livroModel) throws BadRequestException {
        return livroRepository.save(livroModel);
    }

    public ResponseEntity<LivroModel> tratativarParaCadastrarLivro(LivroModel livroModel) {
        Optional<LivroModel> livroJaCadastrado = livroRepository.findByTituloLivroAndAutorAndCategoria(
                livroModel.getTituloLivro().trim(),
                livroModel.getAutor().trim(),
                livroModel.getCategoria().trim()
        );

        if (livroJaCadastrado.isPresent()) {
            throw new LivroCadastradoException("Livro já cadastrado!");
        }

        LivroModel livroSalvo = livroRepository.save(livroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }


    @Override
    public LivroModel cadastrarLivro(LivroModel livroModel) throws BadRequestException {
        return tratativarParaCadastrarLivro(livroModel).getBody();
    }

    @Override
    public LivroModel atualizarLivro(LivroModel livroModel) throws BadRequestException {
        return tratativarParaAtualizarLivro(livroModel);
    }

    @Override
    public LivroModel recuperarLivroPorId(long idLivro) {
        return livroRepository.findByIdLivro(idLivro);
    }

    @Override
    public List<LivroModel> listarLivro(){
        return livroRepository.findAll();
    }

    @Override
    public void deletarLivros(){
        livroRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deletarLivroPorIdLivro(Long idLivro){
        if (livroRepository.existsByIdLivro(idLivro)) {
            livroRepository.deleteByIdLivro(idLivro);
        } else {
            throw new RuntimeException("Livro com id " + idLivro + " não encontrado");
        }
    }
}