package app_clinica_vet.app_vet.Cliente.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app_clinica_vet.app_vet.Cliente.dto.ClienteDTO;
import app_clinica_vet.app_vet.Cliente.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDTO> obtenerTodosLosClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public ClienteDTO obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @PostMapping
    public ClienteDTO guardarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.guardarCliente(clienteDTO);
    }

    @PutMapping("/{id}")
    public ClienteDTO actualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.actualizarCliente(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
