package br.com.wzzy.biblioteca.controller;

import br.com.wzzy.biblioteca.service.LivroService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<LivroModel> cadastrarLivro(@RequestBody LivroModel livroModel) throws BadRequestException {
        LivroModel novoLivro = livroService.cadastrarLivro(livroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }


    @PatchMapping("/atualizar-livro")
    public ResponseEntity<LivroModel> atualizarLivro(@RequestBody LivroModel livroModel) {
        try {
            LivroModel livroAtualizado = livroService.atualizarLivro(livroModel);
            return new ResponseEntity<>(livroAtualizado, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/recuperar-livro/{idLivro}")
    public ResponseEntity<LivroModel> recuperarLivroPorIdLivro(@PathVariable Long idLivro) {
        try {
            LivroModel livroRecuperado = livroService.recuperarLivroPorId(idLivro);
            return new ResponseEntity<>(livroRecuperado, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar-livros")
    public ResponseEntity<List<LivroModel>> listarLivros() {
        List<LivroModel> listaLivros = livroService.listarLivro();

        return new ResponseEntity<>(listaLivros, HttpStatus.OK);
    }

    @DeleteMapping("/deletar-livros")
    public void deletarLivros() {
        livroService.deletarLivros();
        ;
    }

    @DeleteMapping("/deletar-livro/{idLivro}")
    public String deletarLivroPorId(@PathVariable Long idLivro) {
        try {
            livroService.deletarLivroPorIdLivro(idLivro);
            return "Livro com ID " + idLivro + " deletado com sucesso.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }


}
