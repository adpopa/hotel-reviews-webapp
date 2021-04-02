package group14.app.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

import com.mongodb.lang.NonNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity("Hotels")
public class Hotel {
	
	@Id
	@Getter
	private String id=new ObjectId().toString();

	@Getter @Setter
	@NonNull
	@NotBlank
	private String name;
	
	@Indexed(
			options = @IndexOptions(unique=true)
	)
	@NonNull
	@lombok.NonNull
	@NotBlank	       
	@Getter @Setter
	private String address;
	
	@NonNull
	@lombok.NonNull
	@NotBlank
	@Getter @Setter
	private String country;
	
	@NonNull
	@lombok.NonNull
	@NotBlank
	@Getter @Setter
	private String city;
	
	@NonNull
	@lombok.NonNull
	
	@NotBlank
	@Email
	@Indexed(
		options = @IndexOptions(unique=true)
	)
	@Getter @Setter
	private String email;
	
} 
