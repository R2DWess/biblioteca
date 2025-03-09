package br.com.wzzy.biblioteca.controller;

import br.com.wzzy.biblioteca.dto.ClienteDTO;
import br.com.wzzy.biblioteca.model.entity.Cliente;
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
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clienteDTO){
        return clienteService.cadastrarCliente(clienteDTO);
    }

    @PatchMapping("/atualizar")
    public ClienteDTO atualizarCliente(@RequestBody ClienteDTO clienteDTO){
        return clienteService.atualizarCliente(clienteDTO);
    }

    @GetMapping("/listar-clientes")
    public List<Cliente> listarClientes(){
        return clienteService.listarClientes();
    }

    @DeleteMapping("/deletar/{idCliente}")
    public void deletarCliente(@PathVariable Long idCliente){
        clienteService.deletarCliente(idCliente);
    }

    @DeleteMapping("/deletar-todos")
    public void deletarTodosClientes(){
        clienteService.deletarTodosClientes();
    }

    @GetMapping("/{idCliente}")
    public Cliente encontrarClientePorId(@PathVariable Long idCliente){
        return clienteService.encontrarClientePorId(idCliente);
    }
}
