package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
