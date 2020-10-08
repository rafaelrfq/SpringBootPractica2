package edu.pucmm.eict.alquiler.repositories;

import edu.pucmm.eict.alquiler.entities.Client;
import edu.pucmm.eict.alquiler.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Invoice findById(long id);
    Invoice findByClient(Client client);
    Invoice findByDate(LocalDate date);
    List<Invoice> findAll();
    List<Invoice> findAllByClient(Client client);
    List<Invoice> findAllByDate(LocalDate date);
}
