package app_clinica_vet.app_vet.Empleado.model;

import app_clinica_vet.app_vet.Cliente.model.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "empleados")
@Data
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String puesto;

    // Relación con Cliente (Un empleado puede atender varios clientes)
    @OneToMany(mappedBy = "empleado")
    private List<Cliente> clientes;

}
