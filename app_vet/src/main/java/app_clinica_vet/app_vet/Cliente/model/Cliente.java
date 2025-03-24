package app_clinica_vet.app_vet.Cliente.model;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.JoinColumn;  // Importante
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;

import app_clinica_vet.app_vet.Facturacion.model.Facturacion;
import app_clinica_vet.app_vet.Mascota.model.Mascota;
import app_clinica_vet.app_vet.Mensajeria.model.Mensajeria;
//import app_clinica_vet.app_vet.Empleado.model.Empleado;  // Importante


@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;


    // Relación con Mascotas (Un cliente puede tener varias mascotas)
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Mascota> mascotas;

    // Relación con Facturación (Un cliente puede tener varias facturas)
    @OneToMany(mappedBy = "cliente")
    private List<Facturacion> facturas;

    // Relación con Mensajería (Un cliente puede recibir varios mensajes)
    @OneToMany(mappedBy = "cliente")
    private List<Mensajeria> mensajes;

    // Relación con Empleado (Un cliente tiene un empleado asignado)
    /* 
    @ManyToOne
    @JoinColumn(name = "empleado_id")  // El nombre de la columna en la base de datos
    private Empleado empleado;
    */
}
