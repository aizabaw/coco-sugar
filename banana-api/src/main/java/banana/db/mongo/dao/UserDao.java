/**
 * @author aiza
 * @since 9-June-2018
 */

package banana.db.mongo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import banana.db.mongo.map.UserDoc;
import banana.main.constants.StatusCode;
import banana.main.objects.User;

public class UserDao {
	
	final Morphia morphia = new Morphia();
	
	private Datastore connect() {
		
		System.out.println("*********************************************************");
		System.out.println("****************** Connecting to Mongo ******************");
		System.out.println("*********************************************************");
		
		MongoClientURI cloudUriv34 = new MongoClientURI("mongodb://coco:fireandblood@bananarama-shard-00-00-gnmw7.gcp.mongodb.net:27017,"
				+ "bananarama-shard-00-01-gnmw7.gcp.mongodb.net:27017,bananarama-shard-00-02-gnmw7.gcp.mongodb.net:27017/test?"
				+ "ssl=true&replicaSet=bananarama-shard-0&authSource=admin&retryWrites=true");
		
//		MongoClientURI cloudUriv36 = new MongoClientURI("mongodb+srv://coco:fireandblood@bananarama-gnmw7.gcp.mongodb.net/test?retryWrites=true");
		MongoClient mongoClient = new MongoClient(cloudUriv34);
		morphia.mapPackage("banana.db.mongo.map");
		
		final Datastore ds = morphia.createDatastore(mongoClient, "pos");
		ds.ensureIndexes();
		
		return ds;

	}
	
	public StatusCode insertUser(User user) {
		
		Datastore ds = this.connect();
		
		if (this.getUserByName(user.getUsername()).size() > 0) {
			
			return StatusCode.USER_ALREADY_EXISTS;
			
		} else {
			
			UserDoc userDoc = new UserDoc(user.getUsername(), user.getPassword(), user.getEmail(), user.getRole());
			Key<UserDoc> k = ds.save(userDoc);
			System.out.println("Saved user, id=: " + k.getId());
			
			return StatusCode.DB_SUCCESS;
			
		}
		
	}
	
	public List<User> getAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		
		Query<UserDoc> query = this.connect().createQuery(UserDoc.class);
		List<UserDoc> udList = query.asList();
		for (UserDoc ud: udList) {
			User u = new User();
			
			u.setId(ud.getId().toString());
			u.setUsername(ud.getUsername());
			u.setPassword(ud.getPassword());
			u.setEmail(ud.getEmail());
			u.setRole(ud.getRole());
			u.setDateCreated(ud.getDateCreated());
			u.setLastUpdated(ud.getLastUpdated());
		
			userList.add(u);
		}
		
		return userList;
		
	}
	
	public List<User> getUserByName(String username) {
		
		Query<UserDoc> query = this.connect().createQuery(UserDoc.class).filter("username", username);
		
		List<UserDoc> udList = query.asList();
		List<User> uList = new ArrayList<User>();
		for (UserDoc ud : udList) {
			
			User u = new User();
			u.setId(ud.getId().toString());
			u.setUsername(ud.getUsername());
			u.setPassword(ud.getPassword());
			u.setEmail(ud.getEmail());
			u.setRole(ud.getRole());
			u.setDateCreated(ud.getDateCreated());
			u.setLastUpdated(ud.getLastUpdated());
			
			uList.add(u);
			
		}
		
		return uList;
		
	}
	
	public void updateUser(User user) {
		
		Datastore ds = this.connect();
		
		Query<UserDoc> query = ds.createQuery(UserDoc.class).filter("username", user.getUsername());
		UpdateOperations<UserDoc> update = ds.createUpdateOperations(UserDoc.class);
		update.set("password", user.getPassword());
		update.set("email", user.getEmail());
		update.set("role", user.getRole());
		update.set("last_updated", new Date());
		
		UpdateResults result = ds.update(query, update);
		int updated = result.getUpdatedCount();
		
		System.out.println("Updated " + updated + " collections.");
		
		
	}
	
}
