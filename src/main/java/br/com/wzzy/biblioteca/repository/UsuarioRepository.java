package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
