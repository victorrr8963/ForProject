package entities.DAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


import entities.Client;
import entities.Pet;

public class ClientCRUD {

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

	public void getAllClients() {
		System.out.println(".......Hibernate Get Clients.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			Query<Client> query = sessionObj.createQuery("from entities.Client");
			
			List<Client> result = query.getResultList();
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
	
	public void addPetToClient(Client c, Pet p) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			Collection<Pet> petsList = new ArrayList<>();
			petsList.addAll(c.getPetsList());
			petsList.add(p);	
			c.setPetsList(petsList);
			for(Pet i : petsList)
				sessionObj.save(i);
			System.out.println("\n.......Pet Saved Successfully To The Owner.......\n");

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
