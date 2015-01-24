package models;

import javax.persistence.*;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class User extends Model {
    //email is id of user
    @Id
 	private String email;
	private String username;
	private String password;
	private Integer age;
	private String gender;
	private String country;
	
	//private Interests interests;
	//private Lift lift;
	
	private String confirmUser;
	@Formats.NonEmpty
	private Boolean validated = false;
	
	//constructor if user is alredy registrated on freeser
	public User(String email, String username, String password) {
	    this.email = email;
		this.username = username;
		this.password = password;
	}
	//constructor if it is a new user
	public User(String email, String username, String password, Integer age, String gender, String country) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.country = country;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
/*	
	public Interests getInterests() {
		return interests;
	}

	public void setInterests(Interests interests) {
		this.interests = interests;
	}
	
	public Lift getLift() {
		return lift;
	}

	public void setLift(Lift lift) {
		this.lift = lift;
	}
*/	
	//Creates a finder for entity of type T with ID of type I.
	public static Finder<String, User> find = new Finder<String, User>(
		    String.class, User.class
		  );
		  
		  
    //find user by email
    public static User authenticate(String email, String password) {
        return find.where().eq("email", email).eq("password", password).findUnique();
    }
    
    //confirm account
    public static boolean confirm(User user) {
        if(user == null) {
            return false;
        }
        
        user.confirmUser = null;
        user.validated = true;
        user.save();
        
        return true;
    }
}