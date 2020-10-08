package edu.pucmm.eict.alquiler.controllers;

import edu.pucmm.eict.alquiler.entities.Equipment;
import edu.pucmm.eict.alquiler.entities.Rent;
import edu.pucmm.eict.alquiler.services.ClientServices;
import edu.pucmm.eict.alquiler.services.EquipmentServices;
import edu.pucmm.eict.alquiler.services.RentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/rent")
public class RentController {
    @Autowired
    private ClientServices clientServices;
    @Autowired
    private RentServices rentServices;
    @Autowired
    private EquipmentServices equipmentServices;

    @GetMapping("create")
    public String createRent(Model model){
        model.addAttribute("equipment", equipmentServices.findAvailableEquipment());
        model.addAttribute("clients", clientServices.findAllClients());
        return "/rent/create";
    }

    @PostMapping("create")
    public String createdRent(@ModelAttribute("rent")Rent rent, @RequestParam(name = "client") String cedula, @RequestParam(name = "equipment")List<String> equipmentList){
        rent.setClient(clientServices.findClientByCedula(cedula));
        Set<Equipment> equipmentRented = new HashSet<>();
        if(equipmentList != null){
            for(String equipment : equipmentList){
                equipmentRented.add(equipmentServices.findEquipmentById(Long.parseLong(equipment)));
            }
            rent.setEquipment(equipmentRented);
        }
        rentServices.createRent(rent);
        return "redirect:/rent/list";
    }

    @GetMapping("delete")
    public String deleteRent(@PathParam("id") long id){
        rentServices.deleteRent(id);
        return "redirect:/rent/list";
    }

    @GetMapping("list")
    public String listRent(Model model){
        model.addAttribute("rent", rentServices.findAllRent());
        return "/rent/list";
    }
}
