package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    void deleteByIdCliente(Long idCliente);

    Cliente existsByIdCliente(Long idCliente);

    Optional<Cliente> findByIdCliente(Long idCliente);
}
