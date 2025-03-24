package app_clinica_vet.app_vet.Facturacion.model;

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
@Table(name = "facturacion")
@Data
public class Facturacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;
    private String fecha;

    // Relación con Cliente (Una factura pertenece a un cliente)
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
