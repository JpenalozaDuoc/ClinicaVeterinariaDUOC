package app_clinica_vet.app_vet.Historial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app_clinica_vet.app_vet.Historial.model.Historial;
import app_clinica_vet.app_vet.Historial.repository.HistorialRepository;

@Service
public class HistorialService {

    private final HistorialRepository historialRepository;

    public HistorialService(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    public List<Historial> obtenerTodosLosHistoriales() {
        return historialRepository.findAll();
    }

    public Historial obtenerHistorialPorId(Long id) {
        Optional<Historial> historial = historialRepository.findById(id);
        return historial.orElseThrow(() -> new RuntimeException("Historial no encontrado"));
    }

    public Historial guardarHistorial(Historial historial) {
        return historialRepository.save(historial);
    }

    public Historial actualizarHistorial(Long id, Historial historialActualizado) {
        if (historialRepository.existsById(id)) {
            historialActualizado.setId(id);
            return historialRepository.save(historialActualizado);
        } else {
            throw new RuntimeException("Historial no encontrado");
        }
    }

    public void eliminarHistorial(Long id) {
        if (historialRepository.existsById(id)) {
            historialRepository.deleteById(id);
        } else {
            throw new RuntimeException("Historial no encontrado");
        }
    }
}
