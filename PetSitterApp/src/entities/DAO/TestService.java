package entities.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;

import entities.Client;
import entities.Pet;
import entities.PetSitter;
import entities.PetSittingRequest;

public class TestService {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date yourDate, yourDate1, newDate;
		yourDate = sdf.parse("1992-07-26");
		yourDate1 = sdf.parse("2018-07-11");
		newDate = sdf.parse("2019-11-11");
		
		
		
			
		Client c1 = new Client("victor@yahoo.com", "Victor Trusca", "mypassword", "Calea Floresti", "+40757 892 132");
		Client c2 = new Client("hello@gmail.com" , "Andrei Florin", "hardpassword", "Cluj", "0765 873 812");

		Pet p1 = new Pet("Dog", "Rex", 3, "Bone");
		Pet p2 = new Pet("Cat", "Kitty", 2, "Whiskas");

		PetSitter petsitter1 = new PetSitter("raluca@yahoo.com", "Raluca lalsal", "passworsdsadsaDSA","Strada Aldsadksa", "03892138211","a very looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong experience",50);
		PetSitter petsitter2 = new PetSitter("mary_petsittercj@gmail.com", "Maria Popescu", "passWORD", "Calea Motilor", "0755 467 112", "some experience", 40);

		
		PetSittingRequest req1 = new PetSittingRequest(1, yourDate, c1, petsitter1);
		PetSittingRequest req2 = new PetSittingRequest(1, yourDate1, c2, petsitter2);
		
		c1.getPetsList().add(p1);
		/*c1.getRequestsList().add(req1);
		petsitter1.getClientRequestsList().add(req1);
		*/
		
		//CLIENT TESTING
		
		ClientCRUD object = new ClientCRUD();
		//object.addPetToClient(c1, p2);
		
		//c2.setPetsList(petsList);
		//object.deleteClient(c2.getEmail());
		//object.updateClient("hello@gmail.com", "newName", "newPassword", "newAddress", "newPhone");
		
		//object.addClient(c2);
		object.getAllClients();
		
		//PET TESTING
		
		PetCRUD obj = new PetCRUD();
		//obj.deletePet(8);
		obj.addPet(p1);
		
		
		//PET SITTER TESTING

		//PetSitterCRUD obj = new PetSitterCRUD() ;
		//obj.updatePetSitter("mary_petsittercj@gmail.com", "Maria Ionescu", "passWORD", "Calea Motilor", "0755 467 112", "some experience acolo ceva", 40);
		//obj.getAllPetSitters();
	
		//PETSITTING REQUEST TESTING

		
		
		PetSittingRequestCRUD obbj = new PetSittingRequestCRUD();
		//obbj.addPetSittingRequest(req2);
		//obbj.deletePetSittingRequest(9);
		//obbj.updatePetSittingRequest(10, newDate, c2, petsitter2, false);
		//obbj.getAllPetSittingRequests();
	}
}
