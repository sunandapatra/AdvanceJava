package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ILogin;
import DAO.IRegistration;
import DAO.DAOImpl.LoginImpl;
import DAO.DAOImpl.RegistrationImpl;
import Domain.Login;
import Domain.Registration;

@WebServlet({ "/loginServlet" })
public class LoginServlet extends HttpServlet {
	String url = "jdbc:mysql://localhost:3306/sunandapatra";
	String username = "sunandapatra";
	String password = "sonusona14";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("fname");
		String password = request.getParameter("password");
		Login login = new Login();
		login.setFname(fname);
		login.setPassword(password);
		ILogin loginDao = new LoginImpl();
		String userLogin = loginDao.loginUser(login);

		if (userLogin.equals("Login")) {
			request.setAttribute("fname", fname);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
