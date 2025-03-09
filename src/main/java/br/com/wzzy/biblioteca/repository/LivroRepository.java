package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdLivro(Long idLivro);

    List<Livro> idLivro(Long idLivro);
//    Livro findByIdLivro(long idLivro);
//
//    void deleteByIdLivro(Long idLivro);
//
//    boolean existsByIdLivro(Long idLivro);
//
//    long idLivro(Long idLivro);
//
//    boolean existsByTituloLivro(String tituloLivro);
//
//    Optional<Livro> findByTituloLivroAndAutorAndCategoria(String titulo, String categoria, String autor);
//
//}
}