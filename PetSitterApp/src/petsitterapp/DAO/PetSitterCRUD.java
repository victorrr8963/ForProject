package petsitterapp.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import petsitterapp.entities.Client;
import petsitterapp.entities.PetSitter;
import petsitterapp.entities.PetSittingRequest;
import org.springframework.stereotype.Repository;

@Repository
public class PetSitterCRUD {

	public void addPetSitter(PetSitter p) {
		System.out.println(".......Hibernate Add PetSitter.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(p);
			System.out.println("\n.......PetSitter Saved Successfully To The Database.......\n");

			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
	}

	public List<PetSitter> getAllPetSitters() {
		System.out.println(".......Hibernate Get PetSitters.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			Query<PetSitter> query = sessionObj.createQuery("from petsitterapp.entities.PetSitter");
			
			List<PetSitter> result = query.getResultList();
			System.out.println(result.size());

			sessionObj.getTransaction().commit();
			return result;
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return null;
	}
	
	public PetSitter getAPetSitter(String email) {
		System.out.println(".......Hibernate Get A PetSitter.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {

			sessionObj.beginTransaction();
			PetSitter p = sessionObj.find(PetSitter.class, email);

			sessionObj.getTransaction().commit();
			return p;

		} catch (Exception sqlException) {
			
			sqlException.printStackTrace();
		}
		return null;
	}
	
	public void deletePetSitter(String email) {

		System.out.println(".......Hibernate Delete PetSitter.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			PetSitter p = sessionObj.find(PetSitter.class, email);
			sessionObj.remove(p);
			System.out.println("\n.......Records Deleted Successfully from The Database.......\n");

			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	public void updatePetSitter(String email, String newName, String newPassword, String newAddress, String newPhone, String newExperience, int newPrice) {
		System.out.println(".......Hibernate Update PetSitter.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			
			PetSitter p = (PetSitter) sessionObj.get(PetSitter.class, email);
			p.setName(newName);
			p.setPassword(newPassword);
			p.setAddress(newAddress);
			p.setPhoneNumber(newPhone);
			p.setExperience(newExperience);
			p.setPrice(newPrice);
			sessionObj.save(p);
			
			System.out.println("\n.......Records Updated Successfully To The Database.......\n");

			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////LVL 2 METHODS///////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void addRequestToPetsitter(String email, PetSittingRequest p) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {

			sessionObj.beginTransaction();
			
			PetSitter pe = (PetSitter) sessionObj.get(PetSitter.class, email);
			sessionObj.save(p);
			pe.getARequest(p);
			sessionObj.save(pe);

			System.out.println("\n.......Request Updated Successfully To The Client.......\n");
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}
	
	
}
