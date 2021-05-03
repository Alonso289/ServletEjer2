package main.java.daoTablas;

import org.hibernate.Session;

import main.java.filesMapped.Roles;

public class RolesDao {

	//INSERTA UN ROL
	public static void insertRol(Session s, Roles rol) {				
		s.save(rol);		
	}
}
