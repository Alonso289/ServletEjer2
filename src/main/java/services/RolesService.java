package main.java.services;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.daoTablas.RolesDao;
import main.java.daoTablas.UsuariosDao;
import main.java.filesMapped.Roles;

public class RolesService {

	public static boolean insertRol(Session session, Roles rol) {
		//INSERCION EN LA BD
				Transaction tx = null;	
				Boolean correcto = false;
				try {			
					tx = session.beginTransaction();
					RolesDao.insertRol(session, rol);
					tx.commit();
					correcto = true;
				}catch(Exception e) {			
					if(tx != null) {				
						tx.rollback();
						System.out.println(e.getMessage());
						correcto = false;				
					}
				}		
				return correcto;
		
	}
}
