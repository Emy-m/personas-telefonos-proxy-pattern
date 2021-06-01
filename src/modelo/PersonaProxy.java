package modelo;

import java.util.Set;

public class PersonaProxy implements Sujeto {

	private Persona persona;
	private PersonaDao personaDao;
	private int id;
	private String nombre;
	private Set<Telefono> telefonos;

	public PersonaProxy(int id, String nombre, Set<Telefono> telefonos, PersonaDao personaDao) {
		this.id = id;
		this.nombre = nombre;
		this.telefonos = telefonos;
		this.personaDao = personaDao;
		this.persona = null;
	}

	@Override
	public Telefono[] telefonos() { // Se agrega un nuevo telefono luego de popular, que deberia hacer el proxy?
		if (telefonos.isEmpty()) {
			persona = new Persona(id, nombre, popularTelefonos());
		}
		return persona.telefonos();
	}

	@Override
	public String nombre() {
		if (persona == null) {
			persona = new Persona(id, nombre, telefonos);
		}
		return persona.nombre();
	}

	private Set<Telefono> popularTelefonos() {
		return personaDao.telefonosPersonaPorId(id);
	}

}
