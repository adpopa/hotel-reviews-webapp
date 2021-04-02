package group14.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import group14.app.model.Hotel;
import group14.app.dao.HotelDAO;
import group14.app.dao.ReviewDAO;

@Service
public class HotelService {

	@Autowired
	private HotelDAO hotelDAO;
	
	@Autowired
	private ReviewDAO reviewDAO;

	/**
	 * 
	 * @return list of all hotels
	 */
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = hotelDAO.getAllHotels();
		return hotels;
	}
	
	/**
	 * 
	 * @param id
	 * @return hotel by id
	 */
	public Hotel getHotel(String id){
		Hotel hotel = hotelDAO.getHotelById(id);
		return hotel;
	}
	
	/**
	 * 
	 * @param hotel 
	 */
	public void addHotel(Hotel hotel) {
		hotelDAO.addHotel(hotel);
	}
	
	/**
	 * 
	 * @param id 
	 */
	public void deleteHotel(String id) {
		Hotel hotel = hotelDAO.getHotelById(id);
		reviewDAO.deleteReviews(hotel);
		hotelDAO.deleteHotel(hotel);
	}
	
}
