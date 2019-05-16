package petsitterapp.controllers;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import petsitterapp.entities.Client;
import petsitterapp.services.ClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	@RequestMapping("/clients")
	public List<Client> displayClients() {
		
		return clientService.getAllClients();
	}
	
	@RequestMapping("clients/{email}")
	public Client getAClient(@PathVariable String email) {
		return clientService.getClient(email);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/clients")
	public void addClient(@RequestBody Client client) {
		clientService.addClient(client);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clients/{email}")
	public void updateClient(@RequestBody Client client, @PathVariable String email, String newName, String newPassword, String newAddress, String newPhone) {
		clientService.updateClient(email, client, newName, newPassword, newAddress, newPhone);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clients/{email}")
	public void deleteClient(@PathVariable String email) {
		clientService.deleteClient(email);
	}
}
