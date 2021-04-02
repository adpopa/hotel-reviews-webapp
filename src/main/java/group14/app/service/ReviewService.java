/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group14.app.service;
import group14.app.model.Hotel;
import group14.app.model.Review;
import group14.app.model.Users;
import group14.app.dao.HotelDAO;
import group14.app.dao.ReviewDAO;
import group14.app.dao.UserDAO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author christopher
 */
@Service
public class ReviewService {
    
    @Autowired
    ReviewDAO rev_dao;
    
    @Autowired
    HotelDAO hotel_dao;
    
    @Autowired 
    UserDAO user_dao;
       
	/**
	 * 
	 * @return list of all reviews
	 */
    public List<Review> getReviews(){
    	List<Review> reviews = rev_dao.getReviews();
    	return reviews;
    }
	
	/**
	 * 
	 * @param id
	 * @return review by id
	 */
	public Review getReviewById(String id){
		Review review = rev_dao.getReviewById(id);
		return review;
	}
    
	/**
	 * 
	 * @param hotel_id
	 * @param user_id
	 * @param review 
	 */
    public void addReview(String hotel_id, String user_id, Review review){
    	System.out.println("In Service " + hotel_id);
        Hotel hotel = hotel_dao.getHotelById(hotel_id);
        Users user = user_dao.getUserById(user_id);
        review.setDateOfReview(setDate());
        review.setHotel(hotel);
        review.setUser(user);
        rev_dao.addReview(review);
     }
    
	/**
	 * 
	 * @param id 
	 */
    public void deleteReview(String id) {
    	rev_dao.deleteReview(id);
    }
    
	/**
	 * 
	 * @param review 
	 */
	public void addReview(Review review) {
		review.setDateOfReview(setDate());
		rev_dao.addReview(review);		
	}
    
	/**
	 * 
	 * @return the current date as "dd MMMM yyyy"
	 */
    private final static String setDate() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    	return now.format(formatter);
    }

}
