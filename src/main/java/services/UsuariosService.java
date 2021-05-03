package main.java.services;


import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import main.java.daoTablas.UsuariosDao;
import main.java.filesMapped.Usuarios;
import main.java.servlets.Login;



public class UsuariosService {
	
	private static Logger logger = LogManager.getLogger(Login.class);
	//COMPRUEBA CREDENCIALES DE UN USUARIO
	public static boolean compruebaCredenciales(Session session, String user, String pass) {
		logger.info("ENCRIPTANDO CREDENCIALES");	
		//ENCRIPTA LAS PASS
		Base64 base64 = new Base64();
		String passIntro = "";
		passIntro = new String(base64.encode(pass.getBytes()));		
		Usuarios usuario = UsuariosDao.getUsuarios(session, user);
		logger.info("COMPROBANDO  CREDENCIALES");
		boolean correcto = false;	
		logger.info("passIntro "+passIntro);
		logger.info("user "+user);
		if(usuario!=null) {
			
			String passBd = new String (base64.encode(usuario.getClave().getBytes()));
			logger.info("passBd "+passBd);
			if( passIntro.equals(passBd)) 
				correcto = true;
		}
		
		logger.info("CREDENCIALES COMPROBADAS");
		return correcto;
	}

	public static boolean insertarUsuario(Session session, Usuarios user ) {
		//INSERCION EN LA BD
		Transaction tx = null;	
		Boolean correcto = false;
		try {			
			tx = session.beginTransaction();
			UsuariosDao.insertUsuario(session, user);
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
