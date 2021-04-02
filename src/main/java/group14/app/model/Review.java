/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group14.app.model;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotBlank;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import com.mongodb.lang.NonNull;

import lombok.Getter;
import lombok.Setter;
import group14.app.model.Users;

/**
 *
 * @author christopher
 */
@Entity("Reviews")
public class Review {

	@Id
	@Getter
	private String id = new ObjectId().toString();

	@Getter
	@Setter
	@lombok.NonNull
	@NonNull
	private String dateOfReview;

	@Getter
	@Setter
	@lombok.NonNull
	@NonNull
	@NotBlank
	private String comment;

	@Getter
	@Setter
	@lombok.NonNull
	@NonNull
	private double rating;

	@Getter
	@Setter
	@Reference
	@lombok.NonNull
	@NonNull
	private Users user;

	@Getter
	@Setter
	@Reference
	@lombok.NonNull
	@NonNull
	private Hotel hotel;

}
