package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.BibliotecaModel;
import br.com.wzzy.biblioteca.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
    LivroModel findByIdLivro(long idLivro);

    void deleteByIdLivro(Long idLivro);

    boolean existsByIdLivro(Long idLivro);

    long idLivro(Long idLivro);
}
