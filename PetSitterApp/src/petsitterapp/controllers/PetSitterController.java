package petsitterapp.controllers;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import petsitterapp.entities.PetSitter;
import petsitterapp.services.PetSitterService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;;

@RestController
public class PetSitterController {
	
	@Autowired
	private PetSitterService PetSitterService;
	
	
	@RequestMapping("/petsitters")
	public List<PetSitter> displayPetSitters() {
		
		return PetSitterService.getAllPetSitters();
	}
	
	@RequestMapping("petsitters/{email}")
	public PetSitter getAPetSitter(@PathVariable String email) {
		return PetSitterService.getPetSitter(email);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/petsitters")
	public void addPetSitter(@RequestBody PetSitter PetSitter) {
		PetSitterService.addPetSitter(PetSitter);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/petsitters/{email}")
	public void updatePetSitter(@RequestBody PetSitter petSitter, @PathVariable String email, String newName, String newPassword, String newAddress, String newPhone, String newExperience, int newPrice) {
		PetSitterService.updatePetSitter(email, petSitter, newName, newPassword, newAddress, newPhone, newExperience, newPrice);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/petsitters/{email}")
	public void deletePetSitter(@PathVariable String email) {
		PetSitterService.deletePetSitter(email);
	}
}
