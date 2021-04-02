/**
 * DashboardController.java
 */
package group14.app.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Alex Daniel Popa
 *
 */
@Controller
@RequestMapping("/admin")
public class DashboardController {

	/**
	 * 
	 * @param model
	 * @return dashboard view
	 */
	@RequestMapping( value = "/dashboard", method = RequestMethod.GET)
	protected String viewDashboard(Model model) {
		return "admin/dashboard";
	}

}
