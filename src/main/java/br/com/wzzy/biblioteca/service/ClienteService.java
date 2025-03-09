package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.dto.ClienteDTO;
import br.com.wzzy.biblioteca.model.entity.Cliente;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ClienteService {
    ClienteDTO cadastrarCliente(ClienteDTO clienteDTO);

    ClienteDTO atualizarCliente(ClienteDTO clienteDTO);

//    ClienteDTO encontrarClientePorId(ClienteDTO clienteDTO);

//    Cliente recuperarClientePorId(Long idCliente);

    Cliente encontrarClientePorId(Long idCliente);

    List<Cliente> listarClientes();

    void deletarCliente(Long idCliente);

    @Transactional
    void deletarTodosClientes();
}
