/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group14.app.model;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotBlank;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import lombok.Getter;
import lombok.Setter;
import com.mongodb.lang.NonNull;

/**
 *
 * @author christopher
 */
@Entity("HotelRequests")
public class HotelRequest {

	@Id
	@Getter
	private String id = new ObjectId().toString();

	@Getter
	@Setter
	@NotBlank
	@NonNull
	@lombok.NonNull
	private String message;

	@Getter
	@Setter
	@NotBlank
	@NonNull

	@lombok.NonNull
	private String country;

	@Getter
	@Setter
	@NotBlank
	@NotNull
	@lombok.NonNull
	private String city;

	@Getter
	@Setter

	private String user_email;

	@Getter
	@Setter
	@NotBlank
	@NonNull
	@lombok.NonNull
	private String hotel_name;

	@Getter
	@Setter
	@NotBlank
	@NonNull
	@lombok.NonNull
	private String hotel_address;
	
}
