package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdLivro(Long idLivro);

    void deleteByIdLivro(Long idLivro);
}