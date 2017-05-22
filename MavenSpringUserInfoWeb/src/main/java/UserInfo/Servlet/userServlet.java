package UserInfo.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		out.println(service.fetchUserDetails("Aakarsh"));
	}
}
