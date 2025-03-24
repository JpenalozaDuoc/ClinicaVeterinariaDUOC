package app_clinica_vet.app_vet.Cliente.mapper;

import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Component;

import app_clinica_vet.app_vet.Cliente.dto.ClienteDTO;
import app_clinica_vet.app_vet.Cliente.model.Cliente;
import app_clinica_vet.app_vet.Mascota.mapper.MascotaMapper;

@Component
public class ClienteMapper {

    private final MascotaMapper mascotaMapper; // Inyectar el MascotaMapper

    public ClienteMapper(MascotaMapper mascotaMapper) {
        this.mascotaMapper = mascotaMapper;
    }
  
    // Método para convertir de Cliente a ClienteDTO
    public ClienteDTO toClienteDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setTelefono(cliente.getTelefono());

        // Convertir la lista de mascotas a una lista de MascotaDTO
        clienteDTO.setMascotas(cliente.getMascotas().stream()
                .map(mascota -> mascotaMapper.toMascotaDTO(mascota)) // Usar el MascotaMapper para convertir cada mascota
                .collect(Collectors.toList()));

        return clienteDTO;
    }
    


    // Método para convertir de ClienteDTO a Cliente
    public Cliente toCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());

        // Aquí puedes agregar la conversión de mascotas si es necesario
        // Por ejemplo, si tienes un DTO de Mascota, puedes mapearlo a la entidad Mascota

        return cliente;
    }

    // Método para convertir una lista de Clientes a una lista de ClienteDTO
    public List<ClienteDTO> toClienteDTOList(List<Cliente> clientes) {
        return clientes.stream()
                .map(this::toClienteDTO)
                .collect(Collectors.toList());
    }

}
