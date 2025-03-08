package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
