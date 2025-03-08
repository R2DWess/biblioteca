package br.com.wzzy.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
    LivroModel findByIdLivro(long idLivro);

    void deleteByIdLivro(Long idLivro);

    boolean existsByIdLivro(Long idLivro);

    long idLivro(Long idLivro);

    boolean existsByTituloLivro(String tituloLivro);

    Optional<LivroModel> findByTituloLivroAndAutorAndCategoria(String titulo, String categoria, String autor);

}
