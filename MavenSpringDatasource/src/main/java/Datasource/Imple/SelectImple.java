package Datasource.Imple;

import java.sql.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import Datasource.Interface.SelectInterface;

@Component("selectImple")
public class  SelectImple  implements SelectInterface {
	
	@Resource
	private DataSource ds = null;
	
	public String fetchFirstName(int slno) {
		try {
			//get access to jdbc connection object from jdbc connection pool through data source object "ds"
			Connection con = ds.getConnection();
			//persistence logic
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select FName from userregistration1 where SlNo = "+slno);
			if(rs.next()) {
				return rs.getString(1);
			} else {
				System.out.println("No record found with employee number: "+slno);
			}
			rs.close();
			st.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return "Record not found";
		} catch(Exception e) {
			e.printStackTrace();
			return "Record not found";
		}//catch
		return "Record not found";
	}//fetch empName


	public String fetchLastName(int slno) {
		try {
			//get access to jdbc connection object from jdbc connection pool through data source object "ds"
			Connection con = ds.getConnection();
			//persistence logic
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select LName from userregistration1 where SlNo = "+slno);
			if(rs.next()) {
				return rs.getString(1);
			} else {
				System.out.println("No record found with employee number: "+slno);
			}
			rs.close();
			st.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return "Record not found";
		} catch(Exception e) {
			e.printStackTrace();
			return "Record not found";
		}//catch
		return "Record not found";
	}//fetch empName

}