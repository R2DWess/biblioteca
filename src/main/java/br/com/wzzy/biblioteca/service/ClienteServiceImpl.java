package br.com.wzzy.biblioteca.service;

import br.com.wzzy.biblioteca.exception.ClienteCadastradoException;
import br.com.wzzy.biblioteca.exception.ClienteNaoEncontradoException;
import br.com.wzzy.biblioteca.model.ClienteModel;
import br.com.wzzy.biblioteca.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteModel cadastrarCliente(ClienteModel clienteModel){
        if(clienteModel.getNomeCliente().isEmpty()) {
            throw new ClienteCadastradoException("dados incorretos!");
        }

        return clienteRepository.save(clienteModel);
    }

    @Override
    public List<ClienteModel> listarClientes(){
        List<ClienteModel> listarClientes = clienteRepository.findAll();

        if(listarClientes.isEmpty()) {
            throw new ClienteNaoEncontradoException("Nenhum cliente foi encontrado!");
        }

        return listarClientes;

    }
}
