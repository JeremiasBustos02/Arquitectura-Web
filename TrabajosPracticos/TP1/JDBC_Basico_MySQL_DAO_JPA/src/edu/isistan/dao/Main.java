package edu.isistan.dao;

public class Main {

	public static void main(String[] args) throws Exception {
		MySQLPersonaDao personaDAO = new MySQLPersonaDao();
		PersonaService personaService = new PersonaService(personaDAO);
		
		Persona j = new Persona(1, "Jeremias", 23);
		Persona m = new Persona(2, "Mateo", 21);
		
		personaService.addPersona(j);
		personaService.addPersona(m);
		
		for (Persona p : personaService.getPersonas()) {
            System.out.println(p.toString());
        }

		personaDAO.close(); 
	}

}
