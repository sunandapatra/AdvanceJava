package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
@WebServlet({ "/registrationForm" })
public class RegistrationForm extends HttpServlet {
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("fullname");
			String Addr = request.getParameter("address");
			String age = request.getParameter("age");
			String Qual = request.getParameter("qual");
			String Persent = request.getParameter("percent");
			String Year = request.getParameter("yop");
			if(name.isEmpty()||Addr.isEmpty()||age.isEmpty()||Qual.isEmpty()||Persent.isEmpty()||Year.isEmpty())
			{
				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				out.println("<font color=red>Please fill all the fields</font>");
				rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
		}
	}
