package app_clinica_vet.app_vet.Historial.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app_clinica_vet.app_vet.Historial.model.Historial;
import app_clinica_vet.app_vet.Historial.service.HistorialService;

@RestController
@RequestMapping("/api/hitoriales")
public class HistorialController {

    private final HistorialService historialService;

    public HistorialController(HistorialService historialService) {
        this.historialService = historialService;
    }

    @GetMapping
    public List<Historial> obtenerTodosLosHistoriales() {
        return historialService.obtenerTodosLosHistoriales();
    }

    @GetMapping("/{id}")
    public Historial obtenerHistorialPorId(@PathVariable Long id) {
        return historialService.obtenerHistorialPorId(id);
    }

    @PostMapping
    public Historial guardarHistorial(@RequestBody Historial historial) {
        return historialService.guardarHistorial(historial);
    }

    @PutMapping("/{id}")
    public Historial actualizarHistorial(@PathVariable Long id, @RequestBody Historial historial) {
        return historialService.actualizarHistorial(id, historial);
    }

    @DeleteMapping("/{id}")
    public void eliminarHistorial(@PathVariable Long id) {
        historialService.eliminarHistorial(id);
    }

}
