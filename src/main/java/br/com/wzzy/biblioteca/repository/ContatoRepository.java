package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
