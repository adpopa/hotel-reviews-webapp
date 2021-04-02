package group14.app.dao;


import java.util.List;

import javax.validation.ValidationException;

import group14.app.model.Hotel;
import group14.app.model.Users;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.stereotype.Repository;

import com.mongodb.DuplicateKeyException;


@Repository
public class HotelDAO {
    
    
	private MongoConnectionManager manager = MongoConnectionManager.getInstance();
    private Datastore db = manager.getDatastore();
    private Morphia morphia = manager.getMorphia();
    
	/**
	 * 
	 * @return list of all hotels
	 */
	public List<Hotel> getAllHotels() {
		return db.find(Hotel.class).asList();
    }
	
	/**
	 * 
	 * @param id
	 * @return hotel
	 */
	public Hotel getHotelById(String id) {
		Hotel hotel = db.get(Hotel.class, id);
		return hotel;
	}
	
	/**
	 * Method to add a hotel in db
	 * @param hotel 
	 */
	public void addHotel(Hotel hotel) {
		try {
			morphia.map(Hotel.class);
			manager.setMorphia(morphia);
			db.ensureIndexes();
	        db.ensureCaps();
	        db.enableDocumentValidation();
			db.save(hotel);
		}catch(DuplicateKeyException e) {
			System.out.println("duplicate keys");
		}
		catch(ValidationException e) {
			System.out.println("validation error");
		}
		
		catch(NullPointerException e) {
			System.out.println("Null pointer exception");
		}
	}
	
	/**
	 * Method to delete a hotel by id
	 * @param id 
	 */
	public void deleteHotel(String id) {
		db.delete(Hotel.class, id);
	}
	
	/**
	 * method to delete a hotel by a hotel object
	 * @param hotel 
	 */
	public void deleteHotel(Hotel hotel) {
		morphia.map(Hotel.class);
		manager.setMorphia(morphia);
		System.out.println(hotel.toString());
		db.delete(hotel);
	}	
		
}
