package br.com.wzzy.biblioteca.controller;

import br.com.wzzy.biblioteca.model.usuarios.ClienteModel;
import br.com.wzzy.biblioteca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ClienteModel cadastrarCliente (@RequestBody ClienteModel clienteModel){
        return clienteService.cadastrarCliente(clienteModel);
    }

    @GetMapping("listar-clientes")
    public List<ClienteModel> listarClientes (){
        return clienteService.listarClientes();
    }

    @DeleteMapping("deletar/{idCliente}")
    public void deletarClientePorId(@PathVariable Long idCliente) {
        clienteService.deletarClientePorId(idCliente);
    }

    @DeleteMapping("/deletar-todos-clientes")
    public void deletarTodosClientes(){
        clienteService.deletarTodosClientes();

    }

}
