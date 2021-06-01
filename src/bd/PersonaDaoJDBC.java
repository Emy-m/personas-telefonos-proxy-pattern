package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import modelo.PersonaDao;
import modelo.PersonaProxy;
import modelo.Sujeto;
import modelo.Telefono;

public class PersonaDaoJDBC implements PersonaDao {
	private Connection obtenerConexion() {
		String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/persona_proxy";
		String USUARIO = "root";
		String CLAVE = "";
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

			return conexion;
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Hubo un error con la base de datos");
		}
	}

	public Sujeto personaPorId(int id) {
		String sql = "select p.nombre " + "from personas p " + "where p.id_persona = ?";
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> telefonos = new HashSet<Telefono>();
			String nombrePersona = null;
			while (result.next()) {
				nombrePersona = result.getString(1);
			}
			return new PersonaProxy(id, nombrePersona, telefonos, this);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Telefono> telefonosPersonaPorId(int id) {
		String sql = "select t.numero " + "from telefonos t " + "where t.id_persona = ?";
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> telefonos = new HashSet<Telefono>();
			while (result.next()) {
				telefonos.add(new Telefono(result.getString(1)));
			}
			return telefonos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
