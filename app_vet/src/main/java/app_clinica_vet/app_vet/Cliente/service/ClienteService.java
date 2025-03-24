package app_clinica_vet.app_vet.Cliente.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import app_clinica_vet.app_vet.Cliente.dto.ClienteDTO;
import app_clinica_vet.app_vet.Cliente.mapper.ClienteMapper;
import app_clinica_vet.app_vet.Cliente.model.Cliente;
import app_clinica_vet.app_vet.Cliente.repository.ClienteRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper; // Mapper para transformar entre entidades y DTOs

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    /*
    public List<ClienteDTO> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toClienteDTOList(clientes); // Convierte lista de clientes a lista de DTOs
    }
    */
    @Transactional  // Asegura que la sesión de Hibernate esté abierta mientras accedes a las colecciones
    public List<ClienteDTO> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toClienteDTOList(clientes);
    }

    @Transactional
    public ClienteDTO obtenerClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Forzar la inicialización de la colección de mascotas (ya no se necesita si usas fetch EAGER o DTO)
        cliente.getMascotas().size();
        
        return clienteMapper.toClienteDTO(cliente); // Devuelve DTO en lugar de la entidad
    }

    public ClienteDTO guardarCliente(ClienteDTO clienteDTO) {
        // Convertir ClienteDTO a Cliente
        Cliente cliente = clienteMapper.toCliente(clienteDTO);
        // Guardar el Cliente
        Cliente clienteGuardado = clienteRepository.save(cliente);
        return clienteMapper.toClienteDTO(clienteGuardado); // Retornar el ClienteDTO guardado
    }

    public ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO) {
        if (clienteRepository.existsById(id)) {
            // Convertir ClienteDTO a Cliente
            Cliente cliente = clienteMapper.toCliente(clienteDTO);
            cliente.setId(id); // Asegurarnos de que el id esté actualizado
            Cliente clienteGuardado = clienteRepository.save(cliente);
            return clienteMapper.toClienteDTO(clienteGuardado);
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

}