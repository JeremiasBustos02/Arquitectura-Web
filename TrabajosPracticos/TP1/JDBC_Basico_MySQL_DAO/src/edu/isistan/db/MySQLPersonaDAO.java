package edu.isistan.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLPersonaDAO implements PersonaDAO {
	private final String uri = "jdbc:mysql://localhost:3306/DB_TP1";
	private final String user = "root";
	private final String password = "password";
	
	public MySQLPersonaDAO() throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver).getDeclaredConstructor().newInstance();
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(uri, user, password);
	}
	
	@Override
	public void addPersona(Persona persona) throws SQLException {
		String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?, ?, ?)";
		try (Connection conn = this.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setInt(1, persona.getId());
			ps.setString(2, persona.getName());
			ps.setInt(3, persona.getYear());
			ps.executeUpdate();
		}
	}
	
	@Override
	public List<Persona> getAllPersonas() throws SQLException {
		List<Persona> resultado = new ArrayList<>();
		String select = "SELECT * FROM persona";
		try (Connection conn = this.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Persona p = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad"));
				resultado.add(p);
			}
		}
		return resultado;
	}
}
