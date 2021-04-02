/**
 * HotelsController.java
 */
package group14.app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import group14.app.service.HotelService;

/**
 * @author Alex Daniel Popa
 *
 */
@Controller
@RequestMapping("/admin")
public class HotelsController {
	
	@Autowired
    private HotelService hotel_service;
	
	/**
	 * 
	 * @param model
	 * @return view hotels view
	 * @throws Exception 
	 */
    @RequestMapping( value = "/viewhotels", method = RequestMethod.GET)
    protected String viewHotels(Model model) throws Exception {
    	model.addAttribute("hotels", hotel_service.getAllHotels());
    	return "admin/viewhotels";
    }
    
	/**
	 * 
	 * @param pid
	 * @return view hotels view
	 */
    @RequestMapping("/removehotel")
    protected String removeHotel(@RequestParam("pid") String pid) {
    	return "redirect:viewhotels";
    }
}
