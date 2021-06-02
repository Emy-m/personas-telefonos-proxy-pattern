package modelo;

import java.util.Set;

public interface PersonaDao {

	public Persona personaPorId(int id);

	public Set<Telefono> telefonosPersonaPorId(int id);
}
