package edu.isistan.db;

import java.util.List;

public interface PersonaDAO {
	void addPersona(Persona persona) throws Exception;
	List<Persona> getAllPersonas() throws Exception;
}
