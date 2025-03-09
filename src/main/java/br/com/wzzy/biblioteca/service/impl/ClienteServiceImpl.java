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
        if (clienteDTO.getDadosPessoaisDTO().getNome().isEmpty()) {
            throw new ClienteCadastradoException("Dados incorretos!");
        }

        Cliente cliente = ClienteMapper.paraEntidadeCliente(clienteDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ClienteMapper.paraClienteDTO(clienteSalvo);
    }

    @Override
    public ClienteDTO atualizarCliente(ClienteDTO clienteDTO) {

        Cliente cliente = clienteRepository.findByIdCliente(clienteDTO.getIdCliente());

        if (clienteDTO.getIdCliente() == cliente.getIdCliente()) {
            return clienteDTO = cadastrarCliente(clienteDTO);
        }
        throw new ClienteNaoEncontradoException("O cliente com o id" + clienteDTO.getIdCliente() + " não foi encontrado");

    }

    @Override
    public Cliente encontrarClientePorId(Long idCliente){

        return clienteRepository.findByIdCliente(idCliente);
    }


    @Override
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    @Transactional
    @Override
    public void deletarCliente(Long idCliente){
        clienteRepository.deleteByIdCliente(idCliente);
    }

    @Transactional
    @Override
    public void deletarTodosClientes(){
        clienteRepository.deleteAll();
    }

}
