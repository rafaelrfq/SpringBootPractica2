package edu.pucmm.eict.alquiler.services;

import edu.pucmm.eict.alquiler.entities.Client;
import edu.pucmm.eict.alquiler.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public void deleteClient(String cedula) { clientRepository.delete(clientRepository.findByCedula(cedula)); }

    public Client findClientByCedula(String cedula){
        return clientRepository.findByCedula(cedula);
    }

    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }
}
