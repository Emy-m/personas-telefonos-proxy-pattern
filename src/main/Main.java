package main;

import bd.PersonaDaoJDBC;
import modelo.Persona;
import modelo.PersonaDao;
import modelo.Telefono;

public class Main {

	public static void main(String args[]) {
		PersonaDao personaDao = new PersonaDaoJDBC();
		Persona p = personaDao.personaPorId(1);
		System.out.println(p.nombre());
		for (Telefono telefono : p.telefonos()) {
			System.out.println(telefono);
		}
	}

}
