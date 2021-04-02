/**
 * HomeController.java
 */

package group14.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Alex Daniel Popa
 */
@Controller
public class HomeController {

	/**
	 *
	 * @param model
	 * @return index view
	 */
	@RequestMapping( value = {"/", "/index"}, method = RequestMethod.GET)
	protected String helloReview(Model model) {
   		model.addAttribute("username", getPrincipal());
   		model.addAttribute("authority", getAuthority());
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
   		return "index";
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @return index view
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){
	       new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:./";
	 }


	 /**
	  * Method to get the username of the user logged in
	  * @return username
	  */
	private String getPrincipal(){
		String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
	}

	/**
	 * Method to get the the list of authorities of the current user
	 * @return list of authorities
	 */
	private String getAuthority() {
		String privilegies = null;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		List<String> roles = authentication.getAuthorities().stream().map(r -> r.getAuthority()).collect(Collectors.toList());

		for(String r : roles) {
			if(r.matches("ROLE_ANONYMOUS")) { privilegies =  "guest"; } else
			if(r.matches("ROLE_USER")) { privilegies = "user"; } else
			if(r.matches("ROLE_ADMIN")) { privilegies = "admin"; }
		}

		return privilegies;
	}
}
