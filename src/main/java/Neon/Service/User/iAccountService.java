package Neon.Service.User;


import org.springframework.stereotype.Service;

import Neon.Entity.Users;
@Service
public interface iAccountService {
	public int  AddAccount(Users user);
	public Users CheckAccount(Users user);
}
