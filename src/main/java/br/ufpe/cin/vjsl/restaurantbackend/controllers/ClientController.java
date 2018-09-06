package br.ufpe.cin.vjsl.restaurantbackend.controllers;

import br.ufpe.cin.vjsl.restaurantbackend.models.Client;
import br.ufpe.cin.vjsl.restaurantbackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Client> listAllClients(){
        Iterable<Client> clients = clientRepository.findAll();
        return clients;
    }

    //@GetMapping("/findByPhone")
    @RequestMapping("/findByPhone")
    public Client findClientByPhoneNumber( String phone){
        Iterable<Client> clients = clientRepository.findAll();
        Client clientToReturn = null;
        for(Client client : clients){
            if(client.getPhoneNumber().equals(phone)){
                clientToReturn = client;
            }
        }
        return clientToReturn;
    }

    @PostMapping()
    public Client registerClient(@RequestBody @Valid Client client){
       return clientRepository.saveAndFlush(client);
    }

}
