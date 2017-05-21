package jdbcTemplet.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbcTemplet.Interface.InterfaceTemplet;

//Note: Add DAO libraries to build path

public class ImplTemplet implements InterfaceTemplet {
	JdbcTemplate jt;
	String qry;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public boolean delUser(int Slno) {
		qry = "delete from userregistration1 where SlNo = ?";
		int res = jt.update(qry, new Object[] { new Integer(Slno) });
		if (res == 0)
			return false;
		else
			return true;
	}

	/*public int getUserCount(String FName) {
		qry = "select count(*) from userregistration1 where FName = ?";
		int count = jt.queryForInt(qry, new String[] { FName });
		return count;
	}
*/
	/**
	 *
	 */
	public Map getUserDetails(int SlNo){
		qry = "select * from userregistration1 where SlNo = ? ";
		Map m = jt.queryForMap(qry, new Object[] { new Integer(SlNo) });
		return m;
	}

	public List getUserDetails(String FName)  {
		qry = "select * from userregistration1 where FName = ?";
		List l = jt.queryForList(qry, new Object[] { FName });

		return l;
	}

	/**
	 *
	 */
	public boolean modifyAddress(int Slno, String newEmailAdd) {
		// TODO Auto-generated method stub
		qry = "update userregistration1 set email = ? where SlNo = ?";
		int res = jt.update(qry, new Object[] { newEmailAdd, new Integer(Slno) });

		if (res == 0)
			return false;
		else
			return true;
	}

	/**
	 *
	 */
	public boolean registerUser(int Slno, String Fname, String Lname, String email, String userName, String password){
		// TODO Auto-generated method stub
		qry = "insert into userregistration1(SlNo, Fname, Lname, email, userName, password) values(?, ?, ?, ?, ?, ?)";
		int res = jt.update(qry, new Object[] { new Integer(Slno), Fname, Lname, email, userName, password  });
		if (res == 0)
			return false;
		else
			return true;
	}

	public int getUserCount(String FName) {
		// TODO Auto-generated method stub
		return 0;
	}


}