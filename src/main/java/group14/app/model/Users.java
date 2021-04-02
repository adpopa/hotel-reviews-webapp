package group14.app.model;

import javax.validation.constraints.Pattern;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;



import com.mongodb.lang.NonNull;

import group14.app.dao.UserType;
import lombok.Getter;
import lombok.Setter;

@Entity("Users")
public class Users{
	
	@Id
	@Getter
	private String id = new ObjectId().toString();
	
	
	@Getter
    @Setter
    @lombok.NonNull
    @NonNull
    @NotBlank
    @Pattern(regexp="^(?=\\S+$).{5,}$")
	@Indexed(options = @IndexOptions(unique=true))
	private String username;
	
	
	@Getter
    @Setter
    @lombok.NonNull
    @NonNull
    @NotBlank
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")
	private String password;
	
	@Getter
    @Setter
    @lombok.NonNull
    @NonNull
    @NotBlank
    @Email
    @Indexed(options = @IndexOptions(unique=true))
	private String email;
	
	
	@Getter
    @Setter
    @lombok.NonNull
    @NotBlank
    @NonNull
	private String fName;
	
	
	@Getter
    @Setter
    @lombok.NonNull
    @NotBlank
    @NonNull
	private String lName;
	
	
	@Getter
    @Setter
    @lombok.NonNull 
    @NonNull
	private UserType userType;
	
}


