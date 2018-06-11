package banana.db.mongo.map;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Validation;

@Entity ("users")
@Validation ("{username: {minlength: 8, maxlength: 12},"
		+ "password: {maxlength: 100}}")
public class UserDoc {
	
	@Id
	private ObjectId id;
	private String username;
	private String password;
	private String email;
	private String role;
	
	@Property("date_created")
	private Date dateCreated;
	
	@Property("last_updated")
	private Date lastUpdated;
	
	public UserDoc() {
		
	}

	public UserDoc(String username, String password, String email, String role) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.dateCreated = new Date();
		this.lastUpdated = new Date();
		
	}
	
	public ObjectId getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public Date getLastUpdated() {
		return this.lastUpdated;
	}
	
}
