package br.com.wzzy.biblioteca.repository;

import br.com.wzzy.biblioteca.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByIdCliente(Long idCliente);

    void deleteByIdCliente(Long idCliente);

    Cliente existsByIdCliente(Long idCliente);
}
