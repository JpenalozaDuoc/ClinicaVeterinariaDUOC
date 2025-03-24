package app_clinica_vet.app_vet.Cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app_clinica_vet.app_vet.Cliente.model.Cliente;
import app_clinica_vet.app_vet.Cliente.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        if (clienteRepository.existsById(id)) {
            clienteActualizado.setId(id);
            return clienteRepository.save(clienteActualizado);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    public void eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    @Transactional
    public void actualizarCliente(Cliente cliente) {
        clienteRepository.save(cliente); // Guardar el cliente después de la modificación
    }
}
