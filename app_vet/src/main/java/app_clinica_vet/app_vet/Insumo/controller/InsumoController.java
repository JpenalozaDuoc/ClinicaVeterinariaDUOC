package app_clinica_vet.app_vet.Insumo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app_clinica_vet.app_vet.Insumo.model.InsumoMedico;
import app_clinica_vet.app_vet.Insumo.service.InsumoService;

@RestController
@RequestMapping("/api/insumos")
public class InsumoController {

    private final InsumoService insumoService;

    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping
    public List<InsumoMedico> obtenerTodosLosInsumos() {
        return insumoService.obtenerTodosLosInsumos();
    }

    @GetMapping("/{id}")
    public InsumoMedico obtenerInsumoPorId(@PathVariable Long id) {
        return insumoService.obtenerInsumoPorId(id);
    }

    @PostMapping
    public InsumoMedico guardarInsumo(@RequestBody InsumoMedico insumo) {
        return insumoService.guardarInsumo(insumo);
    }

    @PutMapping("/{id}")
    public InsumoMedico actualizarInsumo(@PathVariable Long id, @RequestBody InsumoMedico insumo) {
        return insumoService.actualizarInsumo(id, insumo);
    }

    @DeleteMapping("/{id}")
    public void eliminarInsumo(@PathVariable Long id) {
        insumoService.eliminarInsumo(id);
    }
}
