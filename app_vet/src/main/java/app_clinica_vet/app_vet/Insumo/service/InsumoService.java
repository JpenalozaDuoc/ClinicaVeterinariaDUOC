package app_clinica_vet.app_vet.Insumo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app_clinica_vet.app_vet.Insumo.model.InsumoMedico;
import app_clinica_vet.app_vet.Insumo.repository.InsumoRepository;


@Service
public class InsumoService {
private final InsumoRepository insumoRepository;

    public InsumoService(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    public List<InsumoMedico> obtenerTodosLosInsumos() {
        return insumoRepository.findAll();
    }

    public InsumoMedico obtenerInsumoPorId(Long id) {
        Optional<InsumoMedico> insumo = insumoRepository.findById(id);
        return insumo.orElseThrow(() -> new RuntimeException("Insumo no encontrado"));
    }

    public InsumoMedico guardarInsumo(InsumoMedico insumo) {
        return insumoRepository.save(insumo);
    }

    public InsumoMedico actualizarInsumo(Long id, InsumoMedico insumoActualizado) {
        if (insumoRepository.existsById(id)) {
            insumoActualizado.setId(id);
            return insumoRepository.save(insumoActualizado);
        } else {
            throw new RuntimeException("Insumo no encontrado");
        }
    }

    public void eliminarInsumo(Long id) {
        if (insumoRepository.existsById(id)) {
            insumoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Insumo no encontrado");
        }
    }
}
