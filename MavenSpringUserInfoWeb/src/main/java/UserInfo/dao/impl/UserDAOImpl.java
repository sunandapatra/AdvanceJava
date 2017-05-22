package UserInfo.dao.impl;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import UserInfo.dao.IUserDAO;
import UserInfo.domain.User;

@Component
public class UserDAOImpl implements IUserDAO{

	JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public Map fetchUserDetails(String UserName){
	    		String qry = "select * from userregistration1 where userName = ? ";
	    		Map m = jt.queryForMap(qry, new Object[] { new String(UserName) });
	    		return m;
	    	}
	}

