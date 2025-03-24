package app_clinica_vet.app_vet.Cliente.dto;

import lombok.Data;
import java.util.List;

import app_clinica_vet.app_vet.Mascota.dto.MascotaDTO;


@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<MascotaDTO> mascotas;// Solo nombre o ID de mascotas, si es necesario

    public ClienteDTO(Long id, String nombre, String direccion, String telefono, List<MascotaDTO> mascotas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mascotas = mascotas;
    }

    // Constructor sin parámetros
    public ClienteDTO() {
    }

    // Getter y Setter para cada propiedad

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<MascotaDTO> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaDTO> mascotas) {
        this.mascotas = mascotas;
    }


}
