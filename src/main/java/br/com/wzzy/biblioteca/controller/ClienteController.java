package br.com.wzzy.biblioteca.controller;

import br.com.wzzy.biblioteca.model.ClienteModel;
import br.com.wzzy.biblioteca.service.ClienteService;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastrar")
    public ClienteModel cadastrarCliente (ClienteModel clienteModel){
        return clienteService.cadastrarCliente(clienteModel);
    }

    @GetMapping("listar-clientes")
    public List<ClienteModel> listarClientes (){
        return clienteService.listarClientes();
    }



}
