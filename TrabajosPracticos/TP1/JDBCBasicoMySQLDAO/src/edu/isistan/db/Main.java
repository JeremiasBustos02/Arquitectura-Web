package edu.isistan.db;

public class Main {

	/*
	 Las ventajas que proporciona el patrón DAO:
	 	- Separa la responsabilidad
	 	- Escalabilidad y mantenibilidad
	 	- Menos acoplamiento
	 	- Reutilización y limpieza
	 */
	
	public static void main(String[] args) throws Exception {
		PersonaDAO personaDAO = new MySQLPersonaDAO();
		PersonaService personaService = new PersonaService(personaDAO);
						
		for (Persona p : personaService.getPersonas()) {
            System.out.println(p.toString());
        }
	}

}
