package edu.isistan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.isistan.dao.Persona;

public class Select {

	/*
	 Con JPA tenemos la ventaja de no escribir SQL manualmente, definimos entidades (@Entity) y relaciones
	 JPA se encarga de:
	 	- Generar consultas SQL
	 	- Mapear resultados a objetos Java
	 	- Gestionar transacciones y conexiones automaticamente
	 */
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		
		@SuppressWarnings("unchecked")
		List<Persona> personas = em.createQuery("SELECT p FROM Persona p").getResultList();
		personas.forEach(p -> System.out.println(p));
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
