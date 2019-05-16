package petsitterapp.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PETSITTERS")
public class PetSitter {

	@Id
	@Column(name = "PETSITTER_EMAIL")
	private String email;

	@Column(name = "PETSITTER_NAME")
	private String name;

	@Column(name = "PETSITTER_PASSWORD")
	private String password;

	@Column(name = "PETSITTER_ADDRESS")
	private String address;

	@Column(name = "PETSITTER_PHONE")
	private String phoneNumber;

	@Column(name = "PETSITTER_EXPERIENCE")
	private String experience;

	@Column(name = "PETSITTER_PRICE")
	private int price;

	@OneToMany
	@JoinTable(name = "PETSITTER_REQUESTS", joinColumns = {
			@JoinColumn(name = "PETSITTER_EMAIL") }, inverseJoinColumns = {
					@JoinColumn(name = "PETSITTING_REQUEST_ID") })
	private Collection<PetSittingRequest> clientRequestsList = new ArrayList<>();

	@OneToMany
	@JsonIgnore
	@JoinTable(name = "PETSITTER_ACCEPTED_REQUESTS", joinColumns = {
			@JoinColumn(name = "PETSITTER_EMAIL") }, inverseJoinColumns = {
					@JoinColumn(name = "PETSITTING_REQUEST_ID") })
	private Collection<PetSittingRequest> acceptedRequestsList = new ArrayList<>();

	public PetSitter() {

	}

	public PetSitter(String email, String name, String password, String address, String phoneNumber) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public PetSitter(String email, String name, String password, String address, String phoneNumber, String experience,
			int price) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.experience = experience;
		this.price = price;

	}

	public void getARequest(PetSittingRequest p) {
		this.getClientRequestsList().add(p);
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

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Collection<PetSittingRequest> getClientRequestsList() {
		return clientRequestsList;
	}

	public void setClientRequestsList(Collection<PetSittingRequest> clientRequestsList) {
		this.clientRequestsList = clientRequestsList;
	}

	public Collection<PetSittingRequest> getAcceptedRequestsList() {
		return acceptedRequestsList;
	}

	public void setAcceptedRequestsList(Collection<PetSittingRequest> acceptedRequestsList) {
		this.acceptedRequestsList = acceptedRequestsList;
	}

}
