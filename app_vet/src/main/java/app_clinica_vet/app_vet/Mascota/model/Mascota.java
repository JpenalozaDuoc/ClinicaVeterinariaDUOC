package app_clinica_vet.app_vet.Mascota.model;



import app_clinica_vet.app_vet.Cliente.model.Cliente;
import app_clinica_vet.app_vet.Insumo.model.InsumoMedico;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "mascotas")
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private String raza;

    // Relación con Cliente (Una mascota pertenece a un cliente)
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Relación con Insumo Médico (Una mascota puede recibir varios insumos médicos)
    @OneToMany(mappedBy = "mascota")
    private List<InsumoMedico> insumosMedicos;
}
