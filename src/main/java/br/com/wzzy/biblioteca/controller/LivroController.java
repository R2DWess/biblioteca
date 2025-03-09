package br.com.wzzy.biblioteca.controller;

import br.com.wzzy.biblioteca.dto.LivroDTO;
import br.com.wzzy.biblioteca.exception.LivroCadastradoException;
import br.com.wzzy.biblioteca.mapper.LivroMapper;
import br.com.wzzy.biblioteca.model.entity.Livro;
import br.com.wzzy.biblioteca.repository.LivroRepository;
import br.com.wzzy.biblioteca.service.LivroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/livros")
public class LivroController {

    private final LivroService livroService;
    private final LivroRepository livroRepository;

    @Autowired
    public LivroController(LivroService livroService, LivroRepository livroRepository) {
        this.livroService = livroService;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<LivroDTO> cadastrarLivro(@RequestBody LivroDTO livroDTO) {
        LivroDTO novoLivro = livroService.cadastrarLivro(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @PatchMapping("/atualizar-livros")
    public ResponseEntity<LivroDTO> atualizarLivro(@RequestBody LivroDTO livroDTO) {
        LivroDTO novoLivro = livroService.atualizarLivro(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @GetMapping("/listar-livros")
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    @DeleteMapping("deletar/{idLivro}")
    public void deletarLivroPorId(@PathVariable Long idLivro) {
        livroService.deletarLivroPorId(idLivro);
    }

    @DeleteMapping("deletar-todos")
    public void deletarTodos(){
        livroService.deletarTodos();
    }

    @GetMapping("livro/{idLivro}")
    public List<Livro> recuperarLivro(@PathVariable Long idLivro) {

       return  livroService.recuperarLivroPorIdLivro(idLivro);

    }

}
