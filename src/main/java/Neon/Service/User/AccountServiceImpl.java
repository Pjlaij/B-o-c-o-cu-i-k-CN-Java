package Neon.Service.User;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Neon.DAO.UserDAO;
import Neon.Entity.Users;
@Service
public class AccountServiceImpl implements iAccountService {
	@Autowired
	UserDAO userDAO = new UserDAO();
	
	public int  AddAccount(Users user) {
		
		user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
		
		
		return userDAO.AddAccount(user);
	}


	public Users CheckAccount(Users user) {
		String pwd = user.getPassword();
		List<Users> check;
		check = userDAO.GetUserByAccount(user);
		if(check.size() != 0) {
			if(BCrypt.checkpw(pwd,check.get(0).getPassword()))
			{
				return check.get(0);
			}
			else {
				return null;
			}
		}
		return null;
	}

}
