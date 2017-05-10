package DAO.DAOImpl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public String loginUser(Login login) {
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
    	
		return "Something Went Wrong"; 
}
}
