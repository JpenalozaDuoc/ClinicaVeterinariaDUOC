package app_clinica_vet.app_vet.Empleado.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app_clinica_vet.app_vet.Empleado.model.Empleado;
import app_clinica_vet.app_vet.Empleado.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    public Empleado obtenerEmpleadoPorId(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado.orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado actualizarEmpleado(Long id, Empleado empleadoActualizado) {
        if (empleadoRepository.existsById(id)) {
            empleadoActualizado.setId(id);
            return empleadoRepository.save(empleadoActualizado);
        } else {
            throw new RuntimeException("Empleado no encontrado");
        }
    }

    public void eliminarEmpleado(Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Empleado no encontrado");
        }
    }
}
