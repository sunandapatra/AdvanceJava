package DAO.DAOImpl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import DAO.ILogin;
import Domain.Login;

public class LoginImpl implements ILogin {
	String url = "jdbc:mysql://localhost:3306/sunandapatra";
	String username = "sunandapatra";
	String password = "sonusona14";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;
	private static Logger log = Logger.getLogger(LoginImpl.class);
	
	public String loginUser(Login login) {
		log.info("LoginImpl.loginUser() : START");
		String UserName = login.getFname();
		String Passwod = login.getPassword();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			psmt = con.prepareStatement("Select userName,password from UserRegistration1 where userName=? and password=?");
			psmt.setString(1, UserName);
			psmt.setString(2, Passwod);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) 
            	return "Login";
    		} catch (SQLException e) {
    			e.printStackTrace();
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}    		
		log.info("LoginImpl.loginUser() : END");
		return "Something Went Wrong";
		//return null;
}
}
