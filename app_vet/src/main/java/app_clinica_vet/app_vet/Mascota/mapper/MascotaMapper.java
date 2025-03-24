package app_clinica_vet.app_vet.Mascota.mapper;

import org.springframework.stereotype.Component;

import app_clinica_vet.app_vet.Mascota.dto.MascotaDTO;
import app_clinica_vet.app_vet.Mascota.model.Mascota;

@Component
public class MascotaMapper {

     // Método para convertir de Mascota a MascotaDTO
    public MascotaDTO toMascotaDTO(Mascota mascota) {
        MascotaDTO mascotaDTO = new MascotaDTO();
        mascotaDTO.setId(mascota.getId());
        mascotaDTO.setNombre(mascota.getNombre());
        mascotaDTO.setTipo(mascota.getTipo());
        mascotaDTO.setRaza(mascota.getRaza());
        return mascotaDTO;
    }

    // Método para convertir de MascotaDTO a Mascota
    public Mascota toMascota(MascotaDTO mascotaDTO) {
        Mascota mascota = new Mascota();
        mascota.setId(mascotaDTO.getId());
        mascota.setNombre(mascotaDTO.getNombre());
        mascota.setTipo(mascotaDTO.getTipo());
        mascota.setRaza(mascotaDTO.getRaza());
        return mascota;
    }
}
