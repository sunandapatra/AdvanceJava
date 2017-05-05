package DAO.Implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ICustomerDAO;
import Domain.CustomerDomain;

public class CustomerDAOImpl implements ICustomerDAO {

	String url = "jdbc:mysql://localhost:3306/sunandapatra";
	String username = "sunandapatra";
	String password = "sonusona14";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement psmt = null;

	public List<CustomerDomain> getCustomers() {
		List<CustomerDomain> customer = new ArrayList<CustomerDomain>();
		// Customer cust = new Customer(1, "Sunanda", "Patra", "USA", 45);
		CustomerDomain cust = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

			psmt = con.prepareStatement("select * from customer");
			rs = psmt.executeQuery();
			while (rs.next()) {
				cust = new CustomerDomain();
				cust.setCustomerId(rs.getInt("Customer_Id"));
				cust.setFirstName(rs.getString(2));
				cust.setLastName(rs.getString("Customer_Lname"));
				cust.setAddress(rs.getString("Customer_Address"));
				cust.setPhone(rs.getInt("Customer_Phone"));
				customer.add(cust);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return customer;
	}

}