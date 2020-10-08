package edu.pucmm.eict.alquiler.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    private Set<Equipment> returnedEquipment;

    @ManyToMany
    private Set<Equipment> remainingEquipment;

    @ManyToOne
    private Client client;

    private long totalPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Invoice(){}

    public Invoice(Client client, LocalDate date){
        this.client = client;
        this.date = date;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public Set<Equipment> getReturnedEquipment() { return returnedEquipment; }

    public void setReturnedEquipment(Set<Equipment> returnedEquipment) { this.returnedEquipment = returnedEquipment; }

    public Set<Equipment> getRemainingEquipment() { return remainingEquipment; }

    public void setRemainingEquipment(Set<Equipment> remainingEquipment) { this.remainingEquipment = remainingEquipment; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public long getTotalPrice() { return totalPrice; }

    public void setTotalPrice(long totalPrice) { this.totalPrice = totalPrice; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }
}
