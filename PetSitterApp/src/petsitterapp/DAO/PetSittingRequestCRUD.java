package petsitterapp.DAO;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import petsitterapp.entities.Client;
import petsitterapp.entities.PetSitter;
import petsitterapp.entities.PetSittingRequest;
import org.springframework.stereotype.Repository;

@Repository
public class PetSittingRequestCRUD {

	public void addPetSittingRequest(PetSittingRequest p) {
		System.out.println(".......Hibernate Add PetSittingRequest.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(p);
			System.out.println("\n.......PetSittingRequest Saved Successfully To The Database.......\n");

			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
	}

	public List<PetSittingRequest> getAllPetSittingRequests() {
		System.out.println(".......Hibernate Get PetSittingRequests.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			Query<PetSittingRequest> query = sessionObj.createQuery("from petsitterapp.entities.PetSittingRequest");
			
			List<PetSittingRequest> result = query.getResultList();
			System.out.println(result.size());

			sessionObj.getTransaction().commit();
			return result;
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return null; 
	}
	
	public PetSittingRequest getAPetSittingRequest(int id) {
		System.out.println(".......Hibernate Get A PetSittingRequest.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {

			sessionObj.beginTransaction();
			PetSittingRequest p = sessionObj.find(PetSittingRequest.class, id);

			sessionObj.getTransaction().commit();
			return p;

		} catch (Exception sqlException) {
			
			sqlException.printStackTrace();
		}
		return null;
	}
	
	public void deletePetSittingRequest(int id) {

		System.out.println(".......Hibernate Delete PetSittingRequest.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			PetSittingRequest p = sessionObj.find(PetSittingRequest.class, id);
			sessionObj.remove(p);
			System.out.println("\n.......Records Deleted Successfully from The Database.......\n");

			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	public void updatePetSittingRequest(int id, Date date, Client clientName, PetSitter petSitterName, boolean accepted) {
		System.out.println(".......Hibernate Update PetSittingRequest.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			
			PetSittingRequest p = (PetSittingRequest) sessionObj.get(PetSittingRequest.class, id);
			p.setAccepted(accepted);
			p.setDate(date);
			p.setClientName(clientName);
			p.setPetSitterName(petSitterName);
			sessionObj.save(p);
			
			System.out.println("\n.......Records Updated Successfully To The Database.......\n");

			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		} 
	}
	
	
	
}
