package edu.isistan.db;

public class Main {

	public static void main(String[] args) throws Exception {
		PersonaDAO personaDAO = new MySQLPersonaDAO();
		PersonaService personaService = new PersonaService(personaDAO);
				
		personaService.addPersona(new Persona(3, "El negro manzino", 22));
		
		for (Persona p : personaService.getPersonas()) {
            System.out.println(p.toString());
        }
	}

}
