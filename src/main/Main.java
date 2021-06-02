package main;

import bd.PersonaDaoJDBC;
import modelo.Persona;
import modelo.PersonaDao;
import modelo.Telefono;

public class Main {

	public static void main(String args[]) {
		PersonaDao dao = new PersonaDaoJDBC();
		Persona p = dao.personaPorId(1);
		System.out.println(p.nombre());
		for (Telefono telefono : p.telefonos()) {
			System.out.println(telefono);
		}
	}

}
