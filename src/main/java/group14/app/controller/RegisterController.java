/**
 * RegisterController.java
 */
package group14.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import group14.app.model.Users;
import group14.app.service.UserService;

/**
 *
 * @author Alex Daniel Popa
 */

@Controller
public class RegisterController {

	@Autowired
	UserService userService;

	/**
	 *
	 * @param model
	 * @return register view
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	protected String signUp(Model model) throws Exception {
		model.addAttribute("user", new Users());
		return "register";
	}

	/**
	 *
	 * @param user
	 * @param result
	 * @param model
	 * @return to index if successfuly registered if not return register view
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String submit(@Valid @ModelAttribute("user") Users user, BindingResult result, ModelMap model) {
	    if (result.hasErrors()) {
	        System.out.println(result);
	    }
		System.out.println(user.toString());

		if(result.hasErrors()){
			return "register";
		}

		userService.register(user);

		return "index";
	}
}
