package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.model.usuarios.ClienteModel;

import java.util.List;

public interface ClienteService {
    ClienteModel cadastrarCliente(ClienteModel clienteModel);

    List<ClienteModel> listarClientes();

    void deletarClientePorId(Long idCliente);

    void deletarTodosClientes();
}
