package edu.pucmm.eict.alquiler.services;

import edu.pucmm.eict.alquiler.entities.Equipment;
import edu.pucmm.eict.alquiler.repositories.EquipmentRepository;
import edu.pucmm.eict.alquiler.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentServices {

    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional()
    public Equipment createEquipment(Equipment equipment){
        equipmentRepository.save(equipment);
        return equipment;
    }

    public void deleteEquipment(long id){
        Equipment equipment = equipmentRepository.findById(id);
        equipmentRepository.delete(equipment);
    }

    public Equipment findEquipmentByName(String name){
        return equipmentRepository.findByName(name);
    }

    public Equipment findEquipmentById(long id){ return equipmentRepository.findById(id); }

    public List<Equipment> findAllEquipment(){
        return equipmentRepository.findAllByNameNotNull();
    }

    public List<Equipment> findAvailableEquipment(){
        List<Equipment> availableEquipment = new ArrayList<>();
        for(Equipment eqp : equipmentRepository.findAll()){
            if(inventoryRepository.findByEquipment(eqp).getQuantity() > 0){
                availableEquipment.add(eqp);
            }
        }
        return availableEquipment;
    }
}