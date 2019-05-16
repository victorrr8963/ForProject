package petsitterapp.controllers;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import petsitterapp.entities.Client;
import petsitterapp.entities.PetSitter;
import petsitterapp.entities.PetSittingRequest;
import petsitterapp.services.PetSittingRequestService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;;

@RestController
public class PetSittingRequestController {
	
	@Autowired
	private PetSittingRequestService PetSittingRequestService;
	
	
	@RequestMapping("/petsittingrequests")
	public List<PetSittingRequest> displayPetSittingRequests() {
		
		return PetSittingRequestService.getAllPetSittingRequests();
	}
	
	@RequestMapping("petsittingrequests/{id}")
	public PetSittingRequest getAPetSittingRequest(@PathVariable int id) {
		return PetSittingRequestService.getPetSittingRequest(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/petsittingrequests")
	public void addPetSittingRequest(@RequestBody PetSittingRequest PetSittingRequest) {
		PetSittingRequestService.addPetSittingRequest(PetSittingRequest);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/petsittingrequests/{id}")
	public void updatePetSittingRequest(@RequestBody PetSittingRequest PetSittingRequest, @PathVariable int id, Date date, Client clientName, PetSitter petSitterName, boolean accepted) {
		PetSittingRequestService.updatePetSittingRequest(id,  PetSittingRequest,  date,  clientName,  petSitterName,  accepted);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/petsittingrequests/{id}")
	public void deletePetSittingRequest(@PathVariable int id) {
		PetSittingRequestService.deletePetSittingRequest(id);
	}
}
