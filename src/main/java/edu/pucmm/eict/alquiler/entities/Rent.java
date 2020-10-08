package edu.pucmm.eict.alquiler.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Rent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @ManyToOne
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Equipment> equipment;

    public Rent(){}

    public Rent(LocalDate rentDate, LocalDate dueDate){
        this.rentDate = rentDate;
        this.dueDate = dueDate;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public LocalDate getRentDate() { return rentDate; }

    public void setRentDate(LocalDate rentDate) { this.rentDate = rentDate; }

    public LocalDate getDueDate() { return dueDate; }

    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public Set<Equipment> getEquipment() { return equipment; }

    public void setEquipment(Set<Equipment> equipment) { this.equipment = equipment; }
}
