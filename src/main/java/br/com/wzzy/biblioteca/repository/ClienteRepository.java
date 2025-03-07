package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
