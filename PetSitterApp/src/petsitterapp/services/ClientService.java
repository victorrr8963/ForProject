package petsitterapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petsitterapp.DAO.ClientCRUD;
import petsitterapp.entities.Client;

@Service
public class ClientService {

	@Autowired
	private ClientCRUD clientCRUD;

	public List<Client> getAllClients() {
		return clientCRUD.getAllClients();
	}

	public Client getClient(String email) {
		return clientCRUD.getAClient(email);
	}

	public void addClient(Client c) {
		clientCRUD.addClient(c);
	}

	public void updateClient(String email, Client client, String newName, String newPassword, String newAddress,
			String newPhone) {
		clientCRUD.updateClient(email, newName, newPassword, newAddress, newPhone);
	}

	public void deleteClient(String email) {
		clientCRUD.deleteClient(email);
	}
}
