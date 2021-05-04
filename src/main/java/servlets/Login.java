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

import main.java.services.HibernateUtil;
import main.java.services.UsuariosService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = LogManager.getLogger(Login.class);
	static SessionFactory sessionFactory;
	static Session session = HibernateUtil.getSessionFactory().openSession();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		// TODO Auto-generated method stub
		//OBTENEMOS LAS CREDENCIALES DE USUARIO
		logger.info("INICIANDO SESION Y OBTENIENDO PARAMETROS");
		session = HibernateUtil.getSessionFactory().openSession();		
		String user = request.getParameter("login");
		String pass = request.getParameter("password");
		boolean correcto = UsuariosService.compruebaCredenciales(session, user, pass);

		if(correcto) {
			logger.info("REDIRECCIONANDO");
			request.getRequestDispatcher("opcionesTablas.html").forward(request, response);
		}else {
			logger.info("ERROR PASS");
			request.getRequestDispatcher("LoginError.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	

}
