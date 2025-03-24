package app_clinica_vet.app_vet.Facturacion.controller;
import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app_clinica_vet.app_vet.Facturacion.model.Facturacion;
import app_clinica_vet.app_vet.Facturacion.service.FacturacionService;

@RestController
@RequestMapping("/api/facturas")
public class FacturacionController {

    private final FacturacionService facturacionService;


    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @GetMapping
    public List<Facturacion> obtenerTodasLasFacturas() {
        return facturacionService.obtenerTodasLasFacturas();
    }

    @GetMapping("/{id}")
    public Facturacion obtenerFacturaPorId(@PathVariable Long id) {
        return facturacionService.obtenerFacturaPorId(id);
    }

    @PostMapping
    public Facturacion guardarFactura(@RequestBody Facturacion facturacion) {
        return facturacionService.guardarFactura(facturacion);
    }

    @PutMapping("/{id}")
    public Facturacion actualizarFactura(@PathVariable Long id, @RequestBody Facturacion facturacion) {
        return facturacionService.actualizarFactura(id, facturacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarFactura(@PathVariable Long id) {
        facturacionService.eliminarFactura(id);
    }
}
