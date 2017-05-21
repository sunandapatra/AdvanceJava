package jdbcTemplet.Interface;

import java.util.List;
import java.util.Map;

public interface InterfaceTemplet {

	int getUserCount(String FName);

	List getUserDetails(String FName);

	Map getUserDetails(int SlNo);

	 boolean registerUser(int Slno, String Fname, String Lname, String email, String userName, String password);

	boolean modifyAddress(int Slno, String newAdd);

	boolean delUser(int Slno);

}
