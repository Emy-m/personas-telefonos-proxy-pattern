package modelo;

import java.util.Set;

public interface PersonaDao {

	public Sujeto personaPorId(int id);

	public Set<Telefono> telefonosPersonaPorId(int id);
}
