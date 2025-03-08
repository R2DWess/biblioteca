package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.usuarios.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}
