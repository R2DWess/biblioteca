package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    void deleteByIdCliente(Long idCliente);

    boolean existsByIdCliente(Long idCliente);
}
