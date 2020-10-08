package edu.pucmm.eict.alquiler.repositories;

import edu.pucmm.eict.alquiler.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    Client findByCedula(String cedula);
    List<Client> findAll();
}
