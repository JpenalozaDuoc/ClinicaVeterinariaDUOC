package app_clinica_vet.app_vet.Historial.model;

import app_clinica_vet.app_vet.Cliente.model.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "historial")
@Data
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detalle;
    private String fecha;

    // Relación con Cliente (Un historial pertenece a un cliente)
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
