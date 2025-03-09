package br.com.wzzy.biblioteca.mapper;

import br.com.wzzy.biblioteca.dto.ClienteDTO;
import br.com.wzzy.biblioteca.model.entity.Cliente;

public class ClienteMapper {

    public static Cliente paraEntidadeCliente(ClienteDTO clienteDTO){
        if (clienteDTO == null) return null;

        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setDadosPessoais(DadosPessoaisMapper.paraEntidadeDadosPessoais(clienteDTO.getDadosPessoaisDTO()));
        return cliente;
    }

    public static ClienteDTO paraClienteDTO(Cliente cliente){
        if (cliente == null) return null;

        return new ClienteDTO(
                cliente.getIdCliente(),
                DadosPessoaisMapper.paraDadosPessoasiDTO(cliente.getDadosPessoais())
        );
    }
}