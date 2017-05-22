package UserInfo.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import UserInfo.dao.IUserDAO;
import UserInfo.service.IUserService;

@WebServlet(name = "userServlet")
public class userServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");

		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		IUserDAO service = (IUserDAO) applicationContext.getBean("userServiceImpl");
		//IUserService service = (IUserService) applicationContext.getBean("userServiceImpl");
		//out.println(service.fetchUserDetails(userId));
		Map m = service.fetchUserDetails(userId);
		String Fname=(String)m.get("FName");
		String Lname=(String)m.get("LName");
		String email=(String)m.get("email");
		String userName=(String)m.get("userName");
		request.setAttribute("Fname", Fname);
		request.setAttribute("Lname", Lname);
		request.setAttribute("email", email);
		request.setAttribute("userName", userName);
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}
}
