package DAO.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import DAO.IRegistration;
import Domain.Registration;

public class RegistrationImpl implements IRegistration{
	String url = "jdbc:mysql://localhost:3306/sunandapatra";
	String username = "sunandapatra";
	String password = "sonusona14";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;
	private static Logger log = Logger.getLogger(RegistrationImpl.class);
	
	public  String userRegistration(Registration regd){
		log.info("RegistrationImpl.userRegistration() : START");
		String Fname=regd.getFname();
		String Lname=regd.getLname();
		String Email=regd.getEmail();
		String UName=regd.getUname();
		String Pass=regd.getPass();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			psmt = con.prepareStatement("insert into UserRegistration1(SlNo,FName,LName,email,userName,password) values (NULL,?,?,?,?,?)");
			psmt.setString(1,Fname); 
			psmt.setString(2,Lname); 
			psmt.setString(3,Email); 
			psmt.setString(4,UName); 
			psmt.setString(5,Pass);
			int i = psmt.executeUpdate();

			if (i != 0)
				return "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		log.info("RegistrationImpl.userRegistration() : END");
		return "Something Went Wrong"; 
	}
}