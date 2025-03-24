package app_clinica_vet.app_vet.Mensajeria.model;

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
@Table(name = "mensajeria")
@Data
public class Mensajeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private String fecha;

    // Relación con Cliente (Un cliente puede recibir varios mensajes)
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
