package petsitterapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import petsitterapp.entities.Pet;
import petsitterapp.services.PetService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;;

@RestController
public class PetController {

	@Autowired
	private PetService PetService;

	@RequestMapping("/pets")
	public List<Pet> displayPets() {

		return PetService.getAllPets();
	}

	@RequestMapping("pets/{id}")
	public Pet getAPet(@PathVariable int id) {
		return PetService.getPet(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/pets")
	public void addPet(@RequestBody Pet Pet) {
		PetService.addPet(Pet);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/pets/{id}")
	public void updatePet(@RequestBody Pet Pet, @PathVariable int id, String species, String name, int age,
			String favoriteFood) {
		PetService.updatePet(id, Pet, species, name, age, favoriteFood);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/pets/{id}")
	public void deletePet(@PathVariable int id) {
		PetService.deletePet(id);
	}
}
