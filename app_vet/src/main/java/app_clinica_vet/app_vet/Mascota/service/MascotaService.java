package app_clinica_vet.app_vet.Mascota.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import app_clinica_vet.app_vet.Mascota.model.Mascota;
import app_clinica_vet.app_vet.Mascota.repository.MascotaRepository;


@Service
public class MascotaService {


    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<Mascota> obtenerTodasLasMascotas() {
        return mascotaRepository.findAll();
    }

    public Mascota obtenerMascotaPorId(Long id) {
        Optional<Mascota> mascota = mascotaRepository.findById(id);
        return mascota.orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Mascota actualizarMascota(Long id, Mascota mascotaActualizada) {
        if (mascotaRepository.existsById(id)) {
            mascotaActualizada.setId(id);
            return mascotaRepository.save(mascotaActualizada);
        } else {
            throw new RuntimeException("Mascota no encontrada");
        }
    }

    public void eliminarMascota(Long id) {
        if (mascotaRepository.existsById(id)) {
            mascotaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Mascota no encontrada");
        }
    }
}
