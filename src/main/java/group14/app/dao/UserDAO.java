package group14.app.dao;

import java.util.List;

import javax.validation.ValidationException;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.ValidationExtension;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.mongodb.DuplicateKeyException;

import group14.app.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	private MongoConnectionManager manager=MongoConnectionManager.getInstance();
    private Datastore db=manager.getDatastore();
    private Morphia morphia = manager.getMorphia();    
    
	/**
	 * 
	 * @param user 
	 */
    public void addUser(Users user) {
		try {
			morphia.map(Users.class);
			new ValidationExtension(morphia);
			manager.setMorphia(morphia);
			db.ensureIndexes();
	        db.ensureCaps();
	        db.enableDocumentValidation();
			db.save(user);
		}catch(DuplicateKeyException e) {
			System.out.println("duplicate keys");
		}
		catch(ValidationException e) {
			System.out.println("validation error");
			System.out.println(e.toString());
		}
		catch(NullPointerException e) {
			System.out.println("Null pointer exception");
		}
    	
	}
    
	/**
	 * 
	 * @param user 
	 */
    public void removeUser(Users user) {
		morphia.map(Users.class);
		manager.setMorphia(morphia);
		db.delete(user);
	}
	
	/**
	 * 
	 * @return list of all users
	 */
	public List<Users> getAllUsers() {
		return db.find(Users.class).asList();		
    }
	
	/**
	 * 
	 * @param id
	 * @return list of users by id
	 */
	public Users getUserById(String id) {
		return db.get(Users.class, id);
	}
	
	/**
	 * 
	 * @param username
	 * @return list of users by username
	 */
	public List<Users> getUsersByUsername(String username) {
		return db.find(Users.class).filter("username = ",username).asList();
	}
	
	/**
	 * 
	 * @param user
	 * @param userType 
	 */
	public void updateUserType(Users user, UserType userType) {
		UpdateOperations<Users>update=db.createUpdateOperations(Users.class).set("userType", userType);
		db.update(user,update);
	}	
	
	
}
