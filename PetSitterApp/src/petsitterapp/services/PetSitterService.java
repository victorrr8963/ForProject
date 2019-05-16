package petsitterapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petsitterapp.DAO.PetSitterCRUD;
import petsitterapp.entities.PetSitter;

@Service
public class PetSitterService {

	@Autowired
	private PetSitterCRUD PetSitterCRUD;

	public List<PetSitter> getAllPetSitters() {
		return PetSitterCRUD.getAllPetSitters();
	}

	public PetSitter getPetSitter(String email) {
		return PetSitterCRUD.getAPetSitter(email);
	}

	public void addPetSitter(PetSitter c) {
		PetSitterCRUD.addPetSitter(c);
	}

	public void updatePetSitter(String email, PetSitter petsitter, String newName, String newPassword, String newAddress, String newPhone, String newExperience, int newPrice) {
		PetSitterCRUD.updatePetSitter(email, newName, newPassword, newAddress, newPhone, newExperience, newPrice);
	}

	public void deletePetSitter(String email) {
		PetSitterCRUD.deletePetSitter(email);
	}
}
