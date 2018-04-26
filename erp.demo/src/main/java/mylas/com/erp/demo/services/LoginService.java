package mylas.com.erp.demo.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String usernaem, String password) {
		if(usernaem.equals("admin")&&password.equals("admin123"))
		{
			return true;
		}
		return false;
		
	}
}
