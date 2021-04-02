/**
 * RequestsController.java
 */
package group14.app.controller.admin;

import group14.app.model.Hotel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import group14.app.model.HotelRequest;
import group14.app.service.HotelRequestService;

/**
 * @author Alex Daniel Popa
 *
 */
@Controller
@RequestMapping("/admin")
public class RequestsController {
	
    @Autowired
    private HotelRequestService hotel_req_service;
    
	/**
	 * 
	 * @param model
	 * @return view requests view
	 * @throws Exception 
	 */
	@RequestMapping( value = "/viewrequests", method = RequestMethod.GET)
	protected String viewRequests(Model model) throws Exception {
		model.addAttribute("requests", hotel_req_service.getAllHotelRequests());
		return "admin/viewrequests";
	}
	
	/**
	 * 
	 * @return requests as JSON
	 * @throws Exception 
	 */
	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	protected @ResponseBody List<HotelRequest> getHotelRequests() throws Exception {
		List<HotelRequest> requests = hotel_req_service.getAllHotelRequests();;
		return requests;
	}
	
	/**
	 * Method to delete requests
	 * @param pid
	 * @return view requests view
	 */
    @RequestMapping("/removerequest")
    protected String removeRequest(@RequestParam("pid") String pid) {
    	System.out.println(pid);
    	hotel_req_service.deleteReq(pid);
    	return "redirect:viewrequests";
    }
    
	/**
	 * Method to accept requests
	 * @param pid
	 * @return view requests view
	 */
    @RequestMapping("/acceptrequest")
    protected String acceptRequest(@RequestParam("pid") String pid) {
    	System.out.println(pid);
    	hotel_req_service.acceptRequest(pid);
    	return "redirect:viewrequests";
    }
}
