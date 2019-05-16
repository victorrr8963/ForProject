package petsitterapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petsitterapp.DAO.PetSittingRequestCRUD;
import petsitterapp.entities.Client;
import petsitterapp.entities.PetSitter;
import petsitterapp.entities.PetSittingRequest;

@Service
public class PetSittingRequestService {

	@Autowired
	private PetSittingRequestCRUD PetSittingRequestCRUD;

	public List<PetSittingRequest> getAllPetSittingRequests() {
		return PetSittingRequestCRUD.getAllPetSittingRequests();
	}

	public PetSittingRequest getPetSittingRequest(int id) {
		return PetSittingRequestCRUD.getAPetSittingRequest(id);
	}

	public void addPetSittingRequest(PetSittingRequest p) {
		PetSittingRequestCRUD.addPetSittingRequest(p);
	}

	public void updatePetSittingRequest(int id, PetSittingRequest PetSittingRequest, Date date, Client clientName, PetSitter petSitterName, boolean accepted) {
		PetSittingRequestCRUD.updatePetSittingRequest(id, date, clientName,  petSitterName, accepted);
	}

	public void deletePetSittingRequest(int id) {
		PetSittingRequestCRUD.deletePetSittingRequest(id);
	}
}
