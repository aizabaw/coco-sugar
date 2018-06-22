package banana.main.db.map;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Validation;
import org.mongodb.morphia.utils.IndexType;

@Entity("customers")
//@Validation("{required: [name, date_created, last_updated],"
//		+ "properties: {name: {maxLength: 100}, address: {maxLength: 300},"
//		+ "	contact_no: {maxLength: 20}, email: {maxLength: 30}}}")
@Indexes({@Index(fields=@Field(value="name", type=IndexType.TEXT)), @Index(fields=@Field("address"))})
public class CustomerDoc {

	@Id
	private Object id;
	private String name;
	private String address;
	@Property("contact_no")
	private String contactNo;
	private String email;
	
	@Property("date_created")
	private Date dateCreated;
	@Property("last_updated")
	private Date lastUpdated;
	
	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
