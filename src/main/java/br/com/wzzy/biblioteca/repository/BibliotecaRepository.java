package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.BibliotecaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<BibliotecaModel, Long> {
}
