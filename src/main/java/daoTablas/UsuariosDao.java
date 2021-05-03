package main.java.daoTablas;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import main.java.filesMapped.Usuarios;

public class UsuariosDao {


	//INSERTA UN USUARIO
		public static void insertUsuario(Session s, Usuarios usuario) {				
			s.save(usuario);		
		}
		
		//ACTUALIZA UN USUARIO
		public static void updateUsuario(Session s, Usuarios usuarioActualizado) {				

			Usuarios usuario = s.get(Usuarios.class, usuarioActualizado.getId());
			usuario.setNombre(usuarioActualizado.getNombre());
			usuario.setApellido1(usuarioActualizado.getApellido1());
			usuario.setApellido2(usuarioActualizado.getApellido2());
			usuario.setDireccion(usuarioActualizado.getDireccion());
			usuario.setTelefono(usuarioActualizado.getTelefono());
			
			if (usuario != null) 
				usuario = usuarioActualizado;
						
		}
		
		//ELIMINA UN USUARIO
		public static void deleteUsuario(Session s, int id) {			
			
			Usuarios empleado = s.get(Usuarios.class, id);		
			s.delete(empleado);	
		}
		
		//OBTIENE USUARIO
		public static Usuarios getUsuarios(Session s, String user){
			Usuarios usuario = null;
			String hQuery = "from Usuarios";
			List<Usuarios> listaUsuarios = s.createQuery(hQuery, Usuarios.class).list();
			
			for(int i=0; i<listaUsuarios.size();i++) {
				if(listaUsuarios.get(i).getEmail().equalsIgnoreCase(user))
					usuario = listaUsuarios.get(i);
			}
			
			return usuario;
		}
		
}
