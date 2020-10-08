package edu.pucmm.eict.alquiler.controllers;

import edu.pucmm.eict.alquiler.entities.Client;
import edu.pucmm.eict.alquiler.services.ClientServices;
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
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientServices clientServices;

    @GetMapping("create")
    public String createClient(){
        return "/clients/create";
    }

    @PostMapping("create")
    public String createdClient(@RequestParam(name = "cedula") String cedula, @RequestParam(name = "name") String name, @RequestParam(name = "lastname") String lastname, @RequestParam(name = "picture")MultipartFile picture) throws IOException{
        byte[] bytes = picture.getBytes();
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        Client client = new Client(cedula, name, lastname);
        client.setPicture(encodedString);
        client.setMimeType(picture.getContentType());
        clientServices.createClient(client);
        return "redirect:/clients/list";
    }

    @GetMapping("delete")
    public String deleteClient(@PathParam("cedula") String cedula){
        clientServices.deleteClient(cedula);
        return "redirect:/clients/list";
    }

    @GetMapping("list")
    public String listClients(Model model){
        model.addAttribute("clients", clientServices.findAllClients());
        return "/clients/list";
    }

}
