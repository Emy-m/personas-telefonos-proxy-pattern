package modelo;

import java.util.HashSet;
import java.util.Set;

public class SetProxy<E> extends HashSet<E> {

	private Set<Telefono> telefonos;
	private PersonaDao personaDao;
	private int id;

	public SetProxy(PersonaDao personaDao, int id) {
		this.personaDao = personaDao;
		this.id = id;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		this.telefonos = personaDao.telefonosPersonaPorId(id);
		return telefonos.toArray(a);
	}

}
