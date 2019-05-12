package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PETSITTINGREQUESTS")
public class PetSittingRequest {

	@Id
	@GeneratedValue
	@Column(name = "PETSITTING_REQUEST_ID")
	private int idRequest;

	@Temporal(TemporalType.DATE)
	@Column(name = "PETSITTING_REQUEST_DATE")
	private Date date;

	@ManyToOne
	private Client clientName;

	@ManyToOne
	private PetSitter petSitterName;

	@Column(name = "PETSITTING_REQUEST_ACCEPTED")
	private boolean accepted;

	public PetSittingRequest() {

	}

	public PetSittingRequest(int idRequest, Date date, Client clientName) {
		super();
		this.idRequest = idRequest;
		this.date = date;
		this.clientName = clientName;
		this.petSitterName = null;
		this.accepted = false;
	}

	public PetSittingRequest(int idRequest, Date date, Client clientName, PetSitter petSitterName) {
		super();
		this.idRequest = idRequest;
		this.date = date;
		this.clientName = clientName;
		this.petSitterName = petSitterName;
		this.accepted = false;
	}

	public int getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "PETSITTING_REQUEST_PETSITTER")
	public PetSitter getPetSitterName() {
		return petSitterName;
	}

	public void setPetSitterName(PetSitter petSitterName) {
		this.petSitterName = petSitterName;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	@Column(name = "PETSITTING_REQUEST_CLIENT")
	public Client getClientName() {
		return clientName;
	}

	public void setClientName(Client clientName) {
		this.clientName = clientName;
	}

}
