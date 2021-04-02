/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group14.app.dao;

import org.mongodb.morphia.Datastore;

import group14.app.model.Hotel;
import group14.app.model.HotelRequest;
import java.util.List;
import javax.validation.ValidationException;
import org.mongodb.morphia.Morphia;
import org.springframework.stereotype.Repository;
import com.mongodb.DuplicateKeyException;

/**
 *
 * @author christopher
 */
@Repository
public class HotelRequestDAO {
    
    private MongoConnectionManager manager=MongoConnectionManager.getInstance();
    private Datastore db=manager.getDatastore();
    Morphia morphia = manager.getMorphia();
    
	/**
	 * 
	 * @param req 
	 */
    public void createRequest(HotelRequest req) {
    	try {
			morphia.map(HotelRequest.class);
			manager.setMorphia(morphia);
			db.ensureIndexes();
	        db.ensureCaps();
	        db.enableDocumentValidation();
			db.save(req);
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
	 * 
	 * @param pid 
	 */
	public void acceptRequest(String pid) {
		try {
			HotelRequest request = this.getHotelRequestById(pid);
			
			morphia.map(Hotel.class);
			manager.setMorphia(morphia);
			db.ensureIndexes();
	        db.ensureCaps();
	        db.enableDocumentValidation();
	        
	        Hotel hotel = new Hotel();
	        hotel.setName(request.getHotel_name());
	        hotel.setAddress(request.getHotel_address());
	        hotel.setCountry(request.getCountry());
	        hotel.setCity(request.getCity());
	        hotel.setEmail(request.getUser_email());
	        
			db.save(hotel);
			this.deleteHotelRequest(request);
			
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
	 * 
	 * @return list of hotel requests
	 */
    public List<HotelRequest> getAllRequests() {
    	return db.find(HotelRequest.class).asList();
    }
    
	/**
	 * 
	 * @param id
	 * @return list of hotel request by id
	 */
    public HotelRequest getHotelRequestById(String id) {
    	return db.get(HotelRequest.class,id);
    }
    
	/**
	 * 
	 * @param req 
	 */
    public void deleteHotelRequest(HotelRequest req) {
    	morphia.map(HotelRequest.class);
		manager.setMorphia(morphia);
    	db.delete(req);
    }
    
}
