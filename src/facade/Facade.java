package facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Facade implements DBFacade {
	private String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/persona_proxy";
	private String USUARIO = "root";
	private String CLAVE = "";
	private Connection conexion;

	@Override
	public void open() {
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Hubo un error abriendo la conexion");
		}
	}

	@Override
	public List<Map<String, String>> queryResultAsAsociation(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String[]> queryResultAsArray(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		try {
			conexion.close();
		} catch (SQLException e) {
			throw new RuntimeException("Hubo un error cerrando la conexion");
		}
	}

}
