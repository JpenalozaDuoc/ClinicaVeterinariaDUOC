package app_clinica_vet.app_vet.Cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app_clinica_vet.app_vet.Cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
