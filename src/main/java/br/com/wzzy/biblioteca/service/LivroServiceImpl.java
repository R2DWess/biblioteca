package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.model.*;
import br.com.wzzy.biblioteca.repository.*;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {

    private final BibliotecaRepository bibliotecaRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;



    @Autowired
    public LivroServiceImpl(BibliotecaRepository bibliotecaRepository, ClienteRepository clienteRepository, FuncionarioRepository funcionarioRepository, LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public LivroModel tratativarParaAtualizarLivro(LivroModel livroModel) throws BadRequestException {
        return livroRepository.save(livroModel);
    }

    public LivroModel tratativarParaCadastrarLivro(LivroModel livroModel) throws BadRequestException {

        if (livroRepository.existsByIdLivro(livroModel.getIdLivro())) {
            throw new RuntimeException("Livro já cadastrado");
        }

        return livroRepository.save(livroModel);
    }

    @Override
    public LivroModel cadastrarLivro(LivroModel livroModel) throws BadRequestException {
            return tratativarParaCadastrarLivro(livroModel);

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

        livroRepository.deleteByIdLivro(idLivro);
    }

    public LivroModel recuperarDadosLivro() {
        return new LivroModel();
    }

    public LivroModel capturaTeste(LivroModel dadosRecuperados) {
        LivroModel dadosRecuperadoLivro = recuperarDadosLivro();

        dadosRecuperados.setAutor(dadosRecuperadoLivro.getAutor());
        dadosRecuperados.setCategoria(dadosRecuperadoLivro.getCategoria());
        dadosRecuperados.setStatus(dadosRecuperadoLivro.getStatus());
        dadosRecuperados.setTituloLivro(dadosRecuperadoLivro.getTituloLivro());

        return dadosRecuperados;
    }

}
