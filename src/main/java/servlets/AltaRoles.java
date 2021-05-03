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

import main.java.daoTablas.RolesDao;
import main.java.filesMapped.Roles;
import main.java.services.HibernateUtil;
import main.java.services.RolesService;

/**
 * Servlet implementation class AltaRoles
 */
@WebServlet("/AltaRoles")
public class AltaRoles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(AltaRoles.class);
	static SessionFactory sessionFactory;
	static Session session = HibernateUtil.getSessionFactory().openSession();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaRoles() {
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
		String nombre = request.getParameter("nombre");
		
		//Rol
		Roles rol = new Roles(nombre);					
		//INSERCCION DEL ROL 
		boolean correcto = RolesService.insertRol(session, rol);
	
	
		if(correcto)
			printResponse(response, "ROL REGISTRADO EXITOSAMENTE");
		else
			printResponse(response, "NO SE HA PODIDO REGISTRAR EL ROL");
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
