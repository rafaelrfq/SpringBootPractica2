package edu.pucmm.eict.alquiler.repositories;

import edu.pucmm.eict.alquiler.entities.Equipment;
import edu.pucmm.eict.alquiler.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findById(long id);
    Inventory findByEquipment(Equipment equipment);
    List<Inventory> findAll();
}
