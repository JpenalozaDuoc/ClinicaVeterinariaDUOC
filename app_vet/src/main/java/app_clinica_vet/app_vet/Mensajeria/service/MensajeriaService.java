package app_clinica_vet.app_vet.Mensajeria.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app_clinica_vet.app_vet.Mensajeria.model.Mensajeria;
import app_clinica_vet.app_vet.Mensajeria.repository.MensajeriaRepository;

@Service
public class MensajeriaService {
private final MensajeriaRepository mensajeriaRepository;

    public MensajeriaService(MensajeriaRepository mensajeriaRepository) {
        this.mensajeriaRepository = mensajeriaRepository;
    }

    public List<Mensajeria> obtenerTodasLasMensajerias() {
        return mensajeriaRepository.findAll();
    }

    public Mensajeria obtenerMensajeriaPorId(Long id) {
        Optional<Mensajeria> mensajeria = mensajeriaRepository.findById(id);
        return mensajeria.orElseThrow(() -> new RuntimeException("Mensajería no encontrada"));
    }

    public Mensajeria guardarMensajeria(Mensajeria mensajeria) {
        return mensajeriaRepository.save(mensajeria);
    }

    public Mensajeria actualizarMensajeria(Long id, Mensajeria mensajeriaActualizada) {
        if (mensajeriaRepository.existsById(id)) {
            mensajeriaActualizada.setId(id);
            return mensajeriaRepository.save(mensajeriaActualizada);
        } else {
            throw new RuntimeException("Mensajería no encontrada");
        }
    }

    public void eliminarMensajeria(Long id) {
        if (mensajeriaRepository.existsById(id)) {
            mensajeriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Mensajería no encontrada");
        }
    }
}
