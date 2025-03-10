package br.com.wzzy.biblioteca.service.impl;

import br.com.wzzy.biblioteca.dto.ClienteDTO;
import br.com.wzzy.biblioteca.exception.ClienteNaoEncontradoException;
import br.com.wzzy.biblioteca.mapper.ClienteMapper;
import br.com.wzzy.biblioteca.model.entity.Cliente;
import br.com.wzzy.biblioteca.repository.ClienteRepository;
import br.com.wzzy.biblioteca.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO) {

        Cliente cliente = ClienteMapper.INSTANCE.paraEntidadeCliente(clienteDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ClienteMapper.INSTANCE.paraClienteDTO(clienteSalvo);
    }

    @Override
    public ClienteDTO atualizarCliente(ClienteDTO clienteDTO) {

        buscarClienteId(clienteDTO.getIdClienteDTO());

        return clienteDTO = cadastrarCliente(clienteDTO);

    }

    @Override
    public ClienteDTO buscarClienteId(Long idCliente) {
        Cliente clientes = clienteRepository.findByIdCliente(idCliente)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente com id " + idCliente + " não encontrado!"));
        return ClienteMapper.INSTANCE.paraClienteDTO(clientes);
    }

    @Override
    public List<ClienteDTO> listarClientes() {

        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(ClienteMapper.INSTANCE::paraClienteDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deletarCliente(Long idCliente) {

        ClienteDTO clienteExistente = buscarClienteId(idCliente);

        clienteRepository.deleteByIdCliente(clienteExistente.getIdClienteDTO());
    }
}
