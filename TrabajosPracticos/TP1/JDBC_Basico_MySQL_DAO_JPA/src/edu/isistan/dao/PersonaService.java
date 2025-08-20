package edu.isistan.dao;

import java.util.List;

public class PersonaService {
	private final PersonaDAO personaDAO;
	
	public PersonaService(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}
	
	public void addPersona(Persona persona) throws Exception {
		this.personaDAO.addPersona(persona);
	}
	
	public List<Persona> getPersonas() throws Exception {
		return this.personaDAO.getAllPersonas();
	}
	
}