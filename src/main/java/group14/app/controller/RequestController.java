/**
 * RequestController.java
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

import group14.app.model.HotelRequest;
import group14.app.model.Users;
import group14.app.service.HotelRequestService;

/**
 * @author Alex Daniel Popa
 *
 */
@Controller
public class RequestController {

	@Autowired
	private HotelRequestService requestService;

	/**
	 *
	 * @param model
	 * @return request view
	 * @throws Exception
	 */
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	protected String signUp(Model model) throws Exception {
		model.addAttribute("request", new HotelRequest());
		return "request";
	}

	/**
	 *
	 * @param request
	 * @param result
	 * @param model
	 */
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public void submit(@Valid @ModelAttribute("request") HotelRequest request, BindingResult result, ModelMap model) {
		requestService.createRequest(request);
	}

}
