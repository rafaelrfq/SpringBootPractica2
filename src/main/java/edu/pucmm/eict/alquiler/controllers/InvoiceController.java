package edu.pucmm.eict.alquiler.controllers;

import edu.pucmm.eict.alquiler.entities.Equipment;
import edu.pucmm.eict.alquiler.entities.Invoice;
import edu.pucmm.eict.alquiler.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private ClientServices clientServices;
    @Autowired
    private EquipmentServices equipmentServices;
    @Autowired
    private InvoiceServices invoiceServices;
    @Autowired
    private RentServices rentServices;
    @Autowired
    private InventoryServices inventoryServices;

    @GetMapping("create")
    public String createInvoice(Model model){
        model.addAttribute("clients", clientServices.findAllClients());
        model.addAttribute("equipment", equipmentServices.findAllEquipment());
        return "/invoice/create";
    }

    @PostMapping("create")
    public String createdInvoice(@RequestParam(name = "returnDate")String date, @RequestParam(name = "client") String cedula, @RequestParam(name = "equipment") List<String> equipmentList) {
        Invoice temp = new Invoice(clientServices.findClientByCedula(cedula), LocalDate.parse(date));
        Set<Equipment> equipmentReturned = new HashSet<>();
        Set<Equipment> equipmentRemaining = new HashSet<>();
        if(equipmentList != null){
            for(String equipment : equipmentList){
                for(Equipment eqp : rentServices.findRentByClient(temp.getClient()).getEquipment()){
                    if(equipmentServices.findEquipmentById(Long.parseLong(equipment)).getId() == eqp.getId()){
                        equipmentReturned.add(eqp);
                    } else{
                        equipmentRemaining.add(eqp);
                    }
                }
            }
        }
        temp.setReturnedEquipment(equipmentReturned);
        temp.setRemainingEquipment(equipmentRemaining);
        int days = dateDifference(rentServices.findRentByClient(temp.getClient()).getRentDate(), temp.getDate());
        long totalPrice = 0;
        for(Equipment eqp : temp.getReturnedEquipment()){
            totalPrice += inventoryServices.inventoryByEquipment(eqp).getCostPerDay() * days;
        }
        temp.setTotalPrice(totalPrice);
        invoiceServices.createInvoice(temp);

        return "redirect:/invoice/list";
    }

    @GetMapping("delete")
    public String deleteInvoice(@PathParam("id") long id){
        invoiceServices.deleteInvoice(id);
        return "redirect:/invoice/list";
    }

    @GetMapping("list")
    public String listInvoices(Model model){
        model.addAttribute("invoices", invoiceServices.findAllInvoices());
        return "/invoice/list";
    }

    private int dateDifference(LocalDate date1, LocalDate date2){
        Period period = Period.between(date1, date2);
        return period.getDays();
    }
}
