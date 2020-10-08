package edu.pucmm.eict.alquiler.repositories;

import edu.pucmm.eict.alquiler.entities.Client;
import edu.pucmm.eict.alquiler.entities.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {
    Rent findById(long id);
    Rent findByRentDate(LocalDate date);
    Rent findByDueDate(LocalDate date);
    Rent findByClient(Client client);
    List<Rent> findAll();
}