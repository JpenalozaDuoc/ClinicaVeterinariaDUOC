package app_clinica_vet.app_vet.Mascota.dto;

import lombok.Data;

@Data
public class MascotaDTO {
    private Long id;
    private String nombre;
    private String tipo;
    private String raza;

    public MascotaDTO(Long id, String nombre, String tipo, String raza) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
    }

    // Constructor sin parámetros
    public MascotaDTO() {}

    // Getters y Setters
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
