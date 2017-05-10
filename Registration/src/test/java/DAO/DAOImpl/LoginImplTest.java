package DAO.DAOImpl;

import org.junit.Test;
import Domain.Login;
import static org.junit.Assert.*;
import org.apache.log4j.Logger;

public class LoginImplTest {

	private static Logger log = Logger.getLogger(LoginImplTest.class);
	@Test
	public void loginUser(){
		log.info("LoginImplTest.loginUser() : START");
		Login login = new Login();
		LoginImpl loginimpl = new LoginImpl();
		String loginuser = loginimpl.loginUser(login);
		//assertNotNull("ddd", loginuser);
		assertEquals("Something Went Wrong", loginuser);
	}
}
