package main.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.daoTablas.UsuariosDao;
import main.java.filesMapped.Usuarios;
import main.java.services.HibernateUtil;
import main.java.services.UsuariosService;

/**
 * Servlet implementation class AltaUsuarios
 */
@WebServlet("/AltaUsuarios")
public class AltaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Logger logger = LogManager.getLogger(AltaUsuarios.class);
	static SessionFactory sessionFactory;
	static Session session = HibernateUtil.getSessionFactory().openSession();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("INSERCCION DE UN NUEVO USUARIO");
		
		//Usuario
		int rol = Integer.parseInt(request.getParameter("rol"));		
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String telefono = request.getParameter("telefono");
		String dni = request.getParameter("dni");
		
		Usuarios user = new Usuarios(rol, email, clave, nombre, apellido1, apellido2, direccion, localidad, provincia, telefono, dni);
		boolean correcto = UsuariosService.insertarUsuario(session, user);
		
		if(correcto)
			printResponse(response, "USUARIO REGISTRADO EXITOSAMENTE");
		else
			printResponse(response, "NO SE HA PODIDO REGISTRAR EL USUARIO");
	}

	private void printResponse(HttpServletResponse  response, String string) throws IOException {
		//CODIGO HTML
		PrintWriter res = response.getWriter();
				
		res.println("<html>");
		res.println("<title>Ejercicio Servlet 2</title>");
		res.println("<body>");
		res.println("<h1>" + string + "</h1>");		

		res.println("</table>");
		res.println("</body>");
		res.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
