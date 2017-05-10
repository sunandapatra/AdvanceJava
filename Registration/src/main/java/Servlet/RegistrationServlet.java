package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.IRegistration;
import DAO.DAOImpl.RegistrationImpl;
import Domain.Registration;

@WebServlet({ "/registrationServlet" })
public class RegistrationServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		Registration register = new Registration();
		register.setFname(fname);
		register.setLname(lname);
		register.setEmail(email);
		register.setUname(uname);
		register.setPass(pass);

		IRegistration loginDao = new RegistrationImpl();
		String userRegistered = loginDao.userRegistration(register);

		if (userRegistered.equals("SUCCESS")) {
			request.setAttribute("fname", fname);
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
