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
//
//    @Override
//    public List<ClienteModel> listarClientes(){
//        List<ClienteModel> listarClientes = clienteRepository.findAll();
//
//        if(listarClientes.isEmpty()) {
//            throw new ClienteNaoEncontradoException("Nenhum cliente foi encontrado!");
//        }
//
//        return listarClientes;
//
//    }
//
//    public boolean encontrarClientePorId(Long idCliente) {
//
//        boolean clienteEncontrado = clienteRepository.existsByIdCliente(idCliente);
//
//        if (clienteEncontrado) {
//            return clienteEncontrado;
//        }
//            throw new ClienteNaoEncontradoException("Cliente com id " + idCliente + " não encontrado");
//
//    }
//
//    @Override
//    @Transactional
//    public void deletarClientePorId(Long idCliente){
//
//        boolean removerClientePorId = encontrarClientePorId(idCliente);
//
//        clienteRepository.deleteByIdCliente(idCliente);
//    }
//
//    @Override
//    public void deletarTodosClientes(){
//        List<ClienteModel> deletarTodosClientesEncontrados = listarClientes();
//        if(deletarTodosClientesEncontrados.isEmpty()){
//            throw new ClienteNaoEncontradoException("Nenhum cliente foi encontrado!");
//        }
//
//        clienteRepository.deleteAll();
//    }
}
