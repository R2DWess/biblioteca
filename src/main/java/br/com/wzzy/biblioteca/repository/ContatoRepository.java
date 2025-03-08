package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
}
