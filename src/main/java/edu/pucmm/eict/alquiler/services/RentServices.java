package edu.pucmm.eict.alquiler.services;

import edu.pucmm.eict.alquiler.entities.Client;
import edu.pucmm.eict.alquiler.entities.Equipment;
import edu.pucmm.eict.alquiler.entities.Rent;
import edu.pucmm.eict.alquiler.repositories.InventoryRepository;
import edu.pucmm.eict.alquiler.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentServices {
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    public Rent createRent(Rent rent){
        for(Equipment equipment : rent.getEquipment()){
            int quantity = inventoryRepository.findByEquipment(equipment).getQuantity();
            quantity--;
            inventoryRepository.findByEquipment(equipment).setQuantity(quantity);
        }
        return rentRepository.save(rent);
    }

    public void deleteRent(long id) {
        Rent rent = rentRepository.findById(id);
        rentRepository.delete(rent);
    }

    public Rent findRentById(long id){
        return rentRepository.findById(id);
    }

    public Rent findRentByRentDate(LocalDate date){
        return rentRepository.findByRentDate(date);
    }

    public Rent findRentByDueDate(LocalDate date){ return rentRepository.findByDueDate(date); }

    public Rent findRentByClient(Client client){ return rentRepository.findByClient(client); }

    public List<Rent> findAllRent(){
        return rentRepository.findAll();
    }
}
