package edu.pucmm.eict.alquiler.services;

import edu.pucmm.eict.alquiler.entities.Client;
import edu.pucmm.eict.alquiler.entities.Invoice;
import edu.pucmm.eict.alquiler.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceServices {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(long id){
        Invoice invoice = invoiceRepository.findById(id);
        invoiceRepository.delete(invoice);
    }

    public Invoice findInvoiceById(long id){ return invoiceRepository.findById(id); }
    public Invoice findInvoiceByClient(Client client){ return invoiceRepository.findByClient(client); }
    public Invoice findInvoiceByDate(LocalDate date){ return invoiceRepository.findByDate(date); }

    public List<Invoice> findAllInvoices(){ return invoiceRepository.findAll(); }
    public List<Invoice> findAllInvoicesByClient(Client client){ return invoiceRepository.findAllByClient(client); }
    public List<Invoice> findAllInvoicesByDate(LocalDate date){ return invoiceRepository.findAllByDate(date); }
}
