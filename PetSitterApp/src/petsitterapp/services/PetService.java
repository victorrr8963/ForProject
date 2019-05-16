package petsitterapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petsitterapp.DAO.PetCRUD;
import petsitterapp.entities.Pet;

@Service
public class PetService {

	@Autowired
	private PetCRUD PetCRUD;

	public List<Pet> getAllPets() {
		return PetCRUD.getAllPets();
	}

	public Pet getPet(int id) {
		return PetCRUD.getAPet(id);
	}

	public void addPet(Pet c) {
		PetCRUD.addPet(c);
	}

	public void updatePet(int id, Pet Pet, String species, String name, int age, String favoriteFood) {
		PetCRUD.updatePet(id, species, name, age, favoriteFood);
	}

	public void deletePet(int id) {
		PetCRUD.deletePet(id);
	}
}
