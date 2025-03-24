package app_clinica_vet.app_vet.Facturacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app_clinica_vet.app_vet.Facturacion.model.Facturacion;
import app_clinica_vet.app_vet.Facturacion.repository.FacturacionRepository;

@Service
public class FacturacionService {

    private final FacturacionRepository facturacionRepository;

    public FacturacionService(FacturacionRepository facturacionRepository) {
        this.facturacionRepository = facturacionRepository;
    }

    public List<Facturacion> obtenerTodasLasFacturas() {
        return facturacionRepository.findAll();
    }

    public Facturacion obtenerFacturaPorId(Long id) {
        Optional<Facturacion> facturacion = facturacionRepository.findById(id);
        return facturacion.orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    public Facturacion guardarFactura(Facturacion facturacion) {
        return facturacionRepository.save(facturacion);
    }

    public Facturacion actualizarFactura(Long id, Facturacion facturacionActualizada) {
        if (facturacionRepository.existsById(id)) {
            facturacionActualizada.setId(id);
            return facturacionRepository.save(facturacionActualizada);
        } else {
            throw new RuntimeException("Factura no encontrada");
        }
    }

    public void eliminarFactura(Long id) {
        if (facturacionRepository.existsById(id)) {
            facturacionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Factura no encontrada");
        }
    }
}
