package br.com.wzzy.biblioteca.service;

import java.util.List;

public interface ClienteService {
    ClienteModel cadastrarCliente(ClienteModel clienteModel);

    List<ClienteModel> listarClientes();

    void deletarClientePorId(Long idCliente);

    void deletarTodosClientes();
}
