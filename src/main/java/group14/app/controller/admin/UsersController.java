/**
 * UsersController.java
 */
package group14.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import group14.app.dao.UserType;
import group14.app.model.Users;
import group14.app.service.UserService;

/**
 * @author Alex Daniel Popa
 *
 */
@Controller
@RequestMapping("/admin")
public class UsersController {

	@Autowired
	private UserService user_service;
	
	/**
	 * 
	 * @param model
	 * @return view users view
	 * @throws Exception 
	 */
	@RequestMapping(value = "/viewusers", method = RequestMethod.GET)
	protected String viewUsers(Model model) throws Exception {
		model.addAttribute("users", user_service.getAllUsers());
		return "admin/viewusers";
	}
	
	/**
	 * 
	 * @return users as JSON
	 * @throws Exception 
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	protected @ResponseBody List<Users> getUsers() throws Exception {
		List<Users> users = user_service.getAllUsers();
		return users;
	}

	/**
	 * Method to promote users
	 * @param pid
	 * @return view users view
	 */
	@RequestMapping("/promoteuser")
    protected String promoteUser(@RequestParam("pid") String pid) {
    	user_service.updateUserType(pid, UserType.ROLE_ADMIN);
    	return "redirect:viewusers";
    }
	
	/**
	 * Method to delete users
	 * @param pid
	 * @return view users view
	 */
	@RequestMapping("/removeuser")
    protected String removeUser(@RequestParam("pid") String pid) {
    	user_service.deleteUser(pid);
    	return "redirect:viewusers";
    }
}
