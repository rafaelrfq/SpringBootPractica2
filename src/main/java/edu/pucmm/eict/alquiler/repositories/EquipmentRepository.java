package edu.pucmm.eict.alquiler.repositories;

import edu.pucmm.eict.alquiler.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    Equipment findByName(String name);
    Equipment findById(long id);
    List<Equipment> findAllByNameNotNull();
}
