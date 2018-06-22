package banana.main.objects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	
	private String id;
	private String username;
	private String password;
	private String email;
	private String role;
	private Date dateCreated;
	private Date lastUpdated;
	
	public User() {
		super();
	}
	
	public User(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
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
	
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
		
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("ID: " + this.id + ", ");
		strBuff.append("Name: " + this.username + ", ");
		strBuff.append("Email: " + this.email + ", ");
		strBuff.append("Role: " + this.role + ", ");
		strBuff.append("Date created: " + sdf.format(this.dateCreated));
		strBuff.append("Last updated: " + sdf.format(this.lastUpdated));
		
		return strBuff.toString();
	}

}
