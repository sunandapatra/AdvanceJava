package MVC.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MVC.Bean.RegisterBean;
import MVC.DAO.RegisterDAO;

@WebServlet({ "/registerServlet" })
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hello");
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		RegisterBean registerBean = new RegisterBean();
		registerBean.setFullName(fullName);
		registerBean.setEmail(email);
		registerBean.setUserName(userName);
		registerBean.setPassword(password);

		RegisterDAO registerDao = new RegisterDAO();
		String userRegistered = registerDao.registerUser(registerBean);

		if (userRegistered.equals("SUCCESS"))
		{
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
	}

}