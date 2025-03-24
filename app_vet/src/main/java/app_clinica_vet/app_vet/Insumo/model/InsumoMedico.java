package app_clinica_vet.app_vet.Insumo.model;

import app_clinica_vet.app_vet.Mascota.model.Mascota;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "insumos_medicos")
@Data
public class InsumoMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Double precio;

    // Relación con Mascota (Un insumo médico se aplica a una mascota)
    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;
}
