package edu.isistan.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLPersonaDao implements PersonaDAO {
	private final EntityManagerFactory emf;
	
	
	public MySQLPersonaDao() throws Exception {
		this.emf = Persistence.createEntityManagerFactory("Example");
	}
	
	@Override
	public void addPersona(Persona persona) throws Exception {
		EntityManager em = emf.createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
	}
	
	@Override
	public List<Persona> getAllPersonas() throws SQLException {
		EntityManager em = emf.createEntityManager();
		List<Persona> personas;
        try {
            personas = em.createQuery("SELECT p FROM Persona p", Persona.class)
                         .getResultList();
        } finally {
            em.close();
        }
        return personas;
	}
	
	public void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
