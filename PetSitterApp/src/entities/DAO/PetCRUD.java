package entities.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import entities.Client;
import entities.Pet;

public class PetCRUD {

	public void addPet(Pet p) {
		System.out.println(".......Hibernate Add Pet.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(p);
			System.out.println("\n.......Pet Saved Successfully To The Database.......\n");

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

	public void getAllPets() {
		System.out.println(".......Hibernate Get Pets.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			Query<Pet> query = sessionObj.createQuery("from entities.Pet");
			
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
	
	public void deletePet(int id) {

		System.out.println(".......Hibernate Delete Pet.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			Pet p = sessionObj.find(Pet.class, id);
			sessionObj.remove(p);
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
	
	public void updatePet(int id, String species, String name, int age, String favoriteFood) {
		System.out.println(".......Hibernate Update Pet.......\n");
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		try {
			sessionObj.beginTransaction();
			
			Pet p = (Pet) sessionObj.get(Pet.class, id);
			p.setName(name);
			p.setAge(age);
			p.setFavoriteFood(favoriteFood);
			p.setSpecies(species);
			sessionObj.save(p);
			
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
	
	
}
