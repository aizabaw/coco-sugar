package banana.main.db.map;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;

@Entity ("users")
//@Validation ("{"
//		+ "$jsonSchema: {"
//		+ "bsonType: 'object',"
//		+ " required: ['username', 'password', 'email', 'role', 'date_created', 'last_updated'],"
//		+ " properties: {"
//		+ "	  username: {minlength: 8, maxlength: 12},"
//		+ "	  password: {maxlength: 100}}}}")
@Indexes (@Index(fields=@Field("username")))
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

	public UserDoc(String username, String password, String email, String role, Date dateCreated, Date lastUpdated) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		
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
