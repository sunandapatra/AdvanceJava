package Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import DAO.IRegistration;
import DAO.DAOImpl.RegistrationImpl;
import Domain.Registration;

@WebServlet({ "/registrationServlet" })
public class RegistrationServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(RegistrationServlet.class);

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("RegistrationServlet.service() : START");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		log.info("RegistrationServlet.service() Request From :"+request.getRemoteHost());
		Registration register = new Registration();
		register.setFname(fname);
		register.setLname(lname);
		register.setEmail(email);
		register.setUname(uname);
		register.setPass(pass);
		log.debug("FirstName: " + fname);
		IRegistration loginDao = new RegistrationImpl();
		String userRegistered = loginDao.userRegistration(register);
		log.info("userRegistered: " + userRegistered);
		if (userRegistered.equals("SUCCESS")) {
			request.setAttribute("fname", fname);
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
		log.info("RegistrationServlet.service() : END");
	}

}
