package mylas.com.erp.demo.operations;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import mylas.com.erp.demo.EmpDetails;
import mylas.com.erp.demo.service.Client;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	
	Client userDetails = new Client();

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("in auth method");
		  String username = authentication.getName();
	      String password = (String) authentication.getCredentials();
	      System.out.println(username);
	      System.out.println(password);
	        EmpDetails user = new EmpDetails();
	        System.out.println("user Created");
	        user= userDetails.getByUName(username);
	        System.out.println("Client Called");
	 
	        System.out.println(user);
	        System.out.println(user);
	        
	        if (user == null || !user.getUname().equalsIgnoreCase(username)) {
	            throw new BadCredentialsException("Username not found.");
	        }
	 
	        if (!password.equals(user.getPswd())) {
	            throw new BadCredentialsException("Wrong password.");
	        }
	        
	        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        authorities.add(new SimpleGrantedAuthority(user.getRole()));
	        System.out.println(authorities);
	        return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	public boolean supports(Class<?> arg0) {
		return true;
	}

}
