package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
