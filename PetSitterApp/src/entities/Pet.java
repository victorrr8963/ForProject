package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PETS")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PET_ID")
	private int idPet;

	@Column(name = "PET_SPECIES")
	private String species;

	@Column(name = "PET_NAME")
	private String name;

	@Column(name = "PET_AGE")
	private int age;

	@Column(name = "PET_FAVOURITE_FOOD")
	private String favoriteFood;

	public Pet() {

	}

	public Pet(String species, String name, int age, String favoriteFood) {
		super();
		this.species = species;
		this.name = name;
		this.age = age;
		this.favoriteFood = favoriteFood;
	}

	public Pet(int idPet, String species, String name, int age, String favoriteFood) {
		super();
		this.idPet = idPet;
		this.species = species;
		this.name = name;
		this.age = age;
		this.favoriteFood = favoriteFood;
	}

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public String toString() {
		return "ID: " + this.idPet + ", name: " + this.name + ", age:" + this.age + ", Fav food: " + this.favoriteFood;
	}
}
