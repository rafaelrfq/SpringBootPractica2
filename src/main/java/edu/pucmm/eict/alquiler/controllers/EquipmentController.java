package edu.pucmm.eict.alquiler.controllers;

import edu.pucmm.eict.alquiler.entities.Equipment;
import edu.pucmm.eict.alquiler.entities.Inventory;
import edu.pucmm.eict.alquiler.services.EquipmentServices;
import edu.pucmm.eict.alquiler.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentServices equipmentServices;
    @Autowired
    private InventoryServices inventoryServices;

    @GetMapping("create")
    public String createEquipment(){
        return "/equipment/create";
    }

    @PostMapping("create")
    public String createdEquipment(@RequestParam(name = "picture") MultipartFile picture, @RequestParam(name = "name") String name, @RequestParam(name = "category") String category, @RequestParam(name = "cost") Float cost, @RequestParam(name = "amount") Integer amount) throws IOException{
        byte[] bytes = picture.getBytes();
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        Equipment equipment = new Equipment(name, category, encodedString, picture.getContentType());
        equipmentServices.createEquipment(equipment);
        Inventory inventory = new Inventory(amount, cost);
        inventory.setEquipment(equipment);
        inventoryServices.createInventory(inventory);
        return "redirect:/equipment/list";
    }

    @GetMapping("delete")
    public String deleteEquipment(@PathParam("id") long id){
        equipmentServices.deleteEquipment(id);
        return "redirect:/equipment/list";
    }

    @GetMapping("list")
    public String listEquipment(Model model){
        model.addAttribute("inventory", inventoryServices.findAllInventory());
        return "/equipment/list";
    }
}
