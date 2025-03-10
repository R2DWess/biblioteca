package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.dto.ClienteDTO;
import br.com.wzzy.biblioteca.model.entity.Cliente;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ClienteService {
    ClienteDTO cadastrarCliente(ClienteDTO clienteDTO);

    ClienteDTO atualizarCliente(ClienteDTO clienteDTO);

    ClienteDTO buscarClienteId(Long idCliente);

    List<ClienteDTO> listarClientes();

    void deletarCliente(Long idCliente);
}
