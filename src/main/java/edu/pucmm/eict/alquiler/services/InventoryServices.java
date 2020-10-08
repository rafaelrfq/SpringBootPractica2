package edu.pucmm.eict.alquiler.services;

import edu.pucmm.eict.alquiler.entities.Equipment;
import edu.pucmm.eict.alquiler.entities.Inventory;
import edu.pucmm.eict.alquiler.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServices {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory createInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public Inventory inventoryByEquipment(Equipment equipment){
        return inventoryRepository.findByEquipment(equipment);
    }

    public List<Inventory> findAllInventory(){
        return inventoryRepository.findAll();
    }
}
