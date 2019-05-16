package petsitterapp.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.*;
@Entity
@Table(name = "CLIENTS")
public class Client {

	@Id
	@Column(name = "CLIENT_EMAIL")
	private String email;

	@Column(name = "CLIENT_NAME")
	private String name;

	@Column(name = "CLIENT_PASSWORD")
	private String password;

	@Column(name = "CLIENT_ADDRESS")
	private String address;

	@Column(name = "CLIENT_PHONE")
	private String phoneNumber;

	@OneToMany
    @JsonIgnore
	@JoinTable(name = "CLIENT_PETS", joinColumns = { @JoinColumn(name = "CLIENT_EMAIL") }, inverseJoinColumns = {
			@JoinColumn(name = "PET_ID") })
	private Collection<Pet> petsList = new ArrayList<Pet>();

	@OneToMany
    @JsonIgnore
	@ElementCollection(targetClass = PetSittingRequest.class)
	@JoinTable(name = "CLIENT_REQUESTS", joinColumns = { @JoinColumn(name = "CLIENT_EMAIL") }, inverseJoinColumns = {
			@JoinColumn(name = "PETSITTING_REQUEST_ID") })
	private Collection<PetSittingRequest> requestsList = new ArrayList<PetSittingRequest>();

	public Client() {

	}

	public Client(String email, String name, String password, String address, String phoneNumber) {
		super();

		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public void setAPet(Pet p) {
		this.getPetsList().add(p);
	}
	
	public void setARequest(PetSittingRequest p) {
		this.getRequestsList().add(p);
	}
	
	public Collection<Pet> getPetsList() {
		return petsList;
	}

	public void setPetsList(Collection<Pet> petsList) {
		this.petsList = petsList;
	}

	public Collection<PetSittingRequest> getRequestsList() {
		return requestsList;
	}

	public void setRequestsList(Collection<PetSittingRequest> requestsList) {
		this.requestsList = requestsList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		return "Email: " + this.email + ", name: " + this.name + ", address:" + this.address + ", phone"
				+ this.phoneNumber + ", pets: " + this.getPetsList() + ", requests: " + this.getRequestsList();
	}
}
