package edu.pucmm.eict.alquiler.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Inventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Equipment equipment;

    private int quantity;
    private float costPerDay;

    public Inventory(){}

    public Inventory(int quantity, float cost){
        this.quantity = quantity;
        this.costPerDay = cost;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public float getCostPerDay() { return costPerDay; }

    public void setCostPerDay(float costPerDay) { this.costPerDay = costPerDay; }

    public Equipment getEquipment() { return equipment; }

    public void setEquipment(Equipment equipment) { this.equipment = equipment; }
}
