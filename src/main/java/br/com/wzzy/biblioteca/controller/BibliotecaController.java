package br.com.wzzy.biblioteca.controller;

import br.com.wzzy.biblioteca.model.LivroModel;
import br.com.wzzy.biblioteca.repository.LivroRepository;
import br.com.wzzy.biblioteca.service.LivroService;
import br.com.wzzy.biblioteca.service.LivroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/biblioteca")
public class BibliotecaController {

    private final LivroServiceImpl livroService;
    private final LivroRepository livroRepository;

    @Autowired
    public BibliotecaController(LivroServiceImpl livroService1, LivroRepository livroRepository) {
        this.livroService = livroService1;
        this.livroRepository = livroRepository;
    }

//    @PostMapping("/cadastrar-livro")
//    public ResponseEntity<LivroModel> cadastrarLivro(@RequestBody LivroModel livroModel) {
//        try {
//            LivroModel livroCadastrado = livroService.cadastrarLivro(livroModel);
//            return new ResponseEntity<>(livroCadastrado, HttpStatus.CREATED);
//        } catch (Exception exception) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }

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

    @GetMapping("/mostrar-dados")
    public LivroModel mostrar() {
        return livroService.mostrarDados();
    }
}
