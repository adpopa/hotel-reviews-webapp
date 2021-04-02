/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group14.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import group14.app.dao.ReviewDAO;
import group14.app.dao.UserDAO;
import group14.app.dao.UserType;
import group14.app.model.Users;

/**
 *
 * @author christopher
 */
@Service
public class UserService {

	@Autowired
	private UserDAO user_dao =  new UserDAO();
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ReviewDAO reviewDAO;
	
	/**
	 * 
	 * @param user 
	 */
	public void register(Users user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setUserType(UserType.ROLE_USER);
		user_dao.addUser(user);
	}

	/**
	 * 
	 * @param id
	 * @param userType 
	 */
	public void updateUserType(String id, UserType userType) {
		Users user = user_dao.getUserById(id);
		user_dao.updateUserType(user, userType);
	}

	/**
	 * 
	 * @param id 
	 */
	public void deleteUser(String id) {
		Users user = user_dao.getUserById(id);
		reviewDAO.deleteReviews(user);
		user_dao.removeUser(user);
	}

	/**
	 * 
	 * @return list of all users
	 */
	public List<Users> getAllUsers() {
		return user_dao.getAllUsers();
	}

	/**
	 * 
	 * @param username
	 * @return user by username
	 */
	public Users getUserByUsername(String username) {
		return user_dao.getUsersByUsername(username).get(0);
	}	
}
