package br.com.wzzy.biblioteca.service.impl;

import br.com.wzzy.biblioteca.dto.ClienteDTO;
import br.com.wzzy.biblioteca.exception.ClienteCadastradoException;
import br.com.wzzy.biblioteca.exception.ClienteNaoEncontradoException;
import br.com.wzzy.biblioteca.mapper.ClienteMapper;
import br.com.wzzy.biblioteca.model.entity.Cliente;
import br.com.wzzy.biblioteca.repository.ClienteRepository;
import br.com.wzzy.biblioteca.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {
        if (clienteDTO == null || clienteDTO.getDadosPessoaisDTO().getNome().isEmpty()) {
            throw new ClienteCadastradoException("Dados incorretos!");
        }

        Cliente cliente = ClienteMapper.paraEntidadeCliente(clienteDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ClienteMapper.paraClienteDTO(clienteSalvo);
    }

    @Override
    public ClienteDTO atualizarCliente(ClienteDTO clienteDTO) {

        Cliente clienteExistente = encontrarClientePorId(clienteDTO.getIdCliente());

        return cadastrarCliente(clienteDTO);

    }

    @Override
    public Cliente encontrarClientePorId(Long idCliente){

        if (idCliente == null) {
            throw new ClienteNaoEncontradoException("ID do cliente não pode ser nulo.");
        }

        Cliente cliente = clienteRepository.findByIdCliente(idCliente);
        if (cliente == null) {
            throw new ClienteNaoEncontradoException("O cliente com o ID " + idCliente + " não foi encontrado.");
        }


        return cliente;
    }


    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        if (clientes.isEmpty()) {
            throw new ClienteNaoEncontradoException("Nenhum cliente encontrado.");
        }
        return clientes;
    }

    @Transactional
    @Override
    public void deletarCliente(Long idCliente) {
        Cliente clienteExistente = encontrarClientePorId(idCliente);
        clienteRepository.deleteByIdCliente(clienteExistente.getIdCliente());
    }

    @Transactional
    @Override
    public void deletarTodosClientes(){
        clienteRepository.deleteAll();
    }

}
