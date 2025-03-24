package app_clinica_vet.app_vet.Mensajeria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app_clinica_vet.app_vet.Mensajeria.model.Mensajeria;
import app_clinica_vet.app_vet.Mensajeria.service.MensajeriaService;

@RestController
@RequestMapping("/api/mensajerias")
public class MensajeriaController {

    private final MensajeriaService mensajeriaService;

    public MensajeriaController(MensajeriaService mensajeriaService) {
        this.mensajeriaService = mensajeriaService;
    }

    @GetMapping
    public List<Mensajeria> obtenerTodasLasMensajerias() {
        return mensajeriaService.obtenerTodasLasMensajerias();
    }

    @GetMapping("/{id}")
    public Mensajeria obtenerMensajeriaPorId(@PathVariable Long id) {
        return mensajeriaService.obtenerMensajeriaPorId(id);
    }

    @PostMapping
    public Mensajeria guardarMensajeria(@RequestBody Mensajeria mensajeria) {
        return mensajeriaService.guardarMensajeria(mensajeria);
    }

    @PutMapping("/{id}")
    public Mensajeria actualizarMensajeria(@PathVariable Long id, @RequestBody Mensajeria mensajeria) {
        return mensajeriaService.actualizarMensajeria(id, mensajeria);
    }

    @DeleteMapping("/{id}")
    public void eliminarMensajeria(@PathVariable Long id) {
        mensajeriaService.eliminarMensajeria(id);
    }

}
