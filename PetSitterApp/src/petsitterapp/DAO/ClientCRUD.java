package petsitterapp.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import petsitterapp.entities.Client;
import petsitterapp.entities.Pet;
import petsitterapp.entities.PetSittingRequest;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ClientCRUD {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	Session sessionObj = sessionFactory.openSession();

	public void addClient(Client c) {
		System.out.println(".......Hibernate Add Client.......\n");

		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(c);
			System.out.println("\n.......Client Saved Successfully To The Database.......\n");

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

	@SuppressWarnings("unchecked")
	public List<Client> getAllClients() {
		System.out.println(".......Hibernate Get Clients.......\n");
		// Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {

			sessionObj.beginTransaction();
			Query<Client> query = sessionObj.createQuery("from petsitterapp.entities.Client");

			List<Client> result = query.getResultList();
			System.out.println(result);
			System.out.println(result.size());
			sessionObj.getTransaction().commit();
			return result;

		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
		return null;
	}

	public Client getAClient(String email) {
		System.out.println(".......Hibernate Get A Client.......\n");
		// Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {

			sessionObj.beginTransaction();
			Client c = sessionObj.find(Client.class, email);

			sessionObj.getTransaction().commit();
			return c;

		} catch (Exception sqlException) {
			
			sqlException.printStackTrace();
		}
		return null;
	}

	public void deleteClient(String email) {

		System.out.println(".......Hibernate Delete Client.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			Client c = sessionObj.find(Client.class, email);
			sessionObj.remove(c);
			System.out.println("\n.......Records Deleted Successfully from The Database.......\n");

			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
		}
	}

	public void updateClient(String email, String newName, String newPassword, String newAddress, String newPhone) {
		System.out.println(".......Hibernate Update Client.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();

			Client c = (Client) sessionObj.get(Client.class, email);
			c.setName(newName);
			c.setPassword(newPassword);
			c.setAddress(newAddress);
			c.setPhoneNumber(newPhone);
			sessionObj.save(c);

			System.out.println("\n.......Records Updated Successfully To The Database.......\n");

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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////LVL 2 METHODS///////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void getClientPets() {

		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			Query<Pet> query = sessionObj.createQuery("from client_pets");

			List<Pet> result = query.getResultList();
			System.out.println(result.size());

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

	public void addPetToClient(String email, Pet p) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {

			sessionObj.beginTransaction();

			Client c = (Client) sessionObj.get(Client.class, email);
			sessionObj.save(p);
			c.setAPet(p);
			sessionObj.save(c);

			System.out.println("\n.......Pet/s Updated Successfully To The Owner.......\n");
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

	public void addRequestToClient(String email, PetSittingRequest p) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {

			sessionObj.beginTransaction();

			Client c = (Client) sessionObj.get(Client.class, email);
			sessionObj.save(p);
			c.setARequest(p);
			sessionObj.save(c);

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
