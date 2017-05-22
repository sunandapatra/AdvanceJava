package UserInfo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import UserInfo.dao.IUserDAO;
import UserInfo.dao.impl.UserDAOImpl;
import UserInfo.service.IUserService;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService{
	
	 @Resource
	 IUserDAO iUserDAO;

	public Map fetchUserDetails(String UserName) {
		 return iUserDAO.fetchUserDetails(UserName);
	}

}
