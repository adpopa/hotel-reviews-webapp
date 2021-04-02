/**
 * HotelController.java
 */

package group14.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import group14.app.model.Hotel;
import group14.app.model.Review;
import group14.app.model.Users;
import group14.app.service.HotelService;
import group14.app.service.ReviewService;
import group14.app.service.UserService;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

/**
 *
 * @author Alex Daniel Popa
 */
@Controller
public class HotelController {

	@Autowired
	private HotelService hotel_service;

	@Autowired
	private UserService userService;

	@Autowired
	private ReviewService reviewService;

	/**
	 *
	 * @param model
	 * @param id
	 * @return hotel view
	 */
	@RequestMapping(value = "/hotel/{id}", method = RequestMethod.GET)
	public String viewHotel(Model model, @PathVariable("id") String id) {
		Hotel hotel = hotel_service.getHotel(id);
		model.addAttribute("hotels", hotel);
		model.addAttribute("review", new Review());
		model.addAttribute("ratingSelector", ratingSelector());
		return "hotel";
	}

	/**
	 *
	 * @return hotel as json
	 * @throws Exception
	 */
	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	protected @ResponseBody List<Hotel> getHotels() throws Exception {
		List<Hotel> hotels = hotel_service.getAllHotels();
		return hotels;
	}

	/**
	 *
	 * @param id
	 * @param review
	 * @param result
	 * @param model
	 * @return view of hotel
	 */
	@RequestMapping(value ="/hotel/{id}", method = RequestMethod.POST)
	public String submit(@PathVariable("id") String id, @Valid @ModelAttribute("review") Review review, BindingResult result, ModelMap model) {

		review.setHotel(hotel_service.getHotel(id));
		review.setUser(getUser());

		reviewService.addReview(review);

		return "redirect:" + id;
	}

	/**
	 * Method to get the rating options
	 * @return list of ratings
	 */
	protected List<Double> ratingSelector() {

		List<Double> ratingSelector =  new ArrayList<Double>();

		ratingSelector.add(1.0);
		ratingSelector.add(2.0);
		ratingSelector.add(3.0);
		ratingSelector.add(4.0);
		ratingSelector.add(5.0);

		return ratingSelector;
	}


	/**
	 *
	 * @return the user name
	 */
	private Users getUser(){
		String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userService.getUserByUsername(userName);
	}

}
