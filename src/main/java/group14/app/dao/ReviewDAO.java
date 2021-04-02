/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group14.app.dao;

import group14.app.model.Hotel;
import group14.app.model.Review;
import group14.app.model.Users;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.stereotype.Repository;

import com.mongodb.DuplicateKeyException;

/**
 *
 * @author christopher
 */
@Repository
public class ReviewDAO {

	private MongoConnectionManager manager = MongoConnectionManager.getInstance();
	private Datastore db = manager.getDatastore();
	private Morphia morphia = manager.getMorphia();

	/**
	 * 
	 * @param review 
	 */
	public void addReview(Review review) {
		try {
			morphia.map(Review.class);
			manager.setMorphia(morphia);
			db.ensureIndexes();
			db.ensureCaps();
			db.enableDocumentValidation();
			db.save(review);
		} catch (DuplicateKeyException e) {
			System.out.println("duplicate keys");
		} catch (ValidationException e) {
			System.out.println("validation error");
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception");
		}
	}

	/**
	 * 
	 * @return a list of reviews
	 */
	public List<Review> getReviews() {
		return db.find(Review.class).asList();
	}

	/**
	 * 
	 * @param hotel 
	 */
	public void deleteReviews(Hotel hotel) {
		Query<Review> query = db.createQuery(Review.class);
		query.field("hotel").equal(hotel);
		query.forEach(System.out::println);
		db.findAndDelete(query);
	}

	/**
	 * 
	 * @param user 
	 */
	public void deleteReviews(Users user) {
		Query<Review> query = db.createQuery(Review.class);
		query.field("User").equal(user);
		db.findAndDelete(query);
	}

	/**
	 * 
	 * @param id
	 * @return a review by id
	 */
	public Review getReviewById(String id) {
		return db.get(Review.class, id);
	}

	/**
	 * 
	 * @param user
	 * @return list of reviews by user
	 */
	public List<Review> getReviewsByUser(Users user) {
		return db.find(Review.class).filter("User= ", user).asList();
	}

	/**
	 * 
	 * @param id 
	 */
	public void deleteReview(String id) {
		morphia.map(Review.class);
		manager.setMorphia(morphia);
		db.delete(Review.class, id);
	}

}
