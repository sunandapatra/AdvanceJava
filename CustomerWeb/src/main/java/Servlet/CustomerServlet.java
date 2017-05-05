package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ICustomerDAO;
import DAO.Implementation.CustomerDAOImpl;
import Domain.CustomerDomain;

@WebServlet({ "/customerServlet" })
public class CustomerServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("fname");

		ICustomerDAO customerDAO = new CustomerDAOImpl();
		List<CustomerDomain> customers = customerDAO.getCustomers();
		out.println("<html><style><body>");
		out.println("<table><tr><th>Customer Id</th><th>First Name</th>");
		out.println("<th>Last Name</th><th>Address</th><th>Phone</th>");
		out.println("</tr>");

		for (CustomerDomain cust : customers) {
			out.println("<tr>");
			out.println("<td>" + cust.getCustomerId() + "</td>");
			out.println("<td>" + cust.getFirstName() + "</td>");
			out.println("<td>" + cust.getLastName() + "</td>");
			out.println("<td>" + cust.getAddress() + "</td>");
			out.println("<td>" + cust.getPhone() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</body></html>");
	}

}
