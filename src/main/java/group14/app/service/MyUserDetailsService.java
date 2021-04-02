/**
 * MyUserDetailsService.java
 */
package group14.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import group14.app.dao.UserDAO;
import group14.app.model.Users;

/**
 * @author Alex Daniel Popa
 *
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDao;
	
	/**
	 * 
	 * @param username
	 * @return the user credentials and authorities to check if can login
	 * @throws UsernameNotFoundException 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userDao.getUsersByUsername(username).get(0);
		
		if (user == null) {
		      throw new UsernameNotFoundException("User not found");
		}
		
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(String.valueOf(user.getUserType()) ));
		
		return new User(user.getUsername(),user.getPassword(),authorities);
	}	

}
