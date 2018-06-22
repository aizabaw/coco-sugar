/**
 * @author aiza
 * @since 9-June-2018
 */

package banana.main.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.bson.types.ObjectId;
import org.jboss.logging.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.mongodb.WriteConcernException;

import banana.main.dao.DBResponse.DBStatus;
import banana.main.db.map.UserDoc;
import banana.main.objects.User;

public class UserDao {
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	public DBResponse insertUser(User user) {
		
		try {
			
			Datastore ds = MongoConnect.getConnection();
			
			if (ds == null) {
				return new DBResponse(DBStatus.CONNECTION_FAILED);
			}
			
//			if (((List<User>)this.getUserByName(user.getUsername()).getRespObj()).size() > 0) {
//				
//				log.error("User '" + user.getUsername() +  "' already exists");
//				return new DBResponse(DBStatus.ALREADY_EXISTS);
//				
//			} else {
			
				UserDoc userDoc = new UserDoc(user.getUsername(), user.getPassword(), user.getEmail(), user.getRole(), new Date(), new Date());
				Key<UserDoc> k = ds.save(userDoc);
				
				log.info("User saved: " + k.getId());
				return new DBResponse(DBStatus.SUCCESS, k.getId());
				
//			}
			
		} catch (WriteConcernException ex) {
			
			if (ex.getErrorCode() == 121) {
				return new DBResponse(DBStatus.INVALID_PARAMETER, ex.getMessage());
			} else {
				return new DBResponse(DBStatus.FAILED, "DB Error Code: " + ex.getErrorCode());
			}
			
		} catch (Exception ex) {
			log.error(ExceptionUtils.getStackTrace(ex));
			return new DBResponse(DBStatus.FAILED);
		}
		
	}
	
	public DBResponse getAllUsers() {
		
		try {

			List<User> userList = new ArrayList<User>();

			Datastore ds = MongoConnect.getConnection();
			if (ds == null) {
				return new DBResponse(DBStatus.CONNECTION_FAILED);
			}

			Query<UserDoc> query = ds.createQuery(UserDoc.class);
			List<UserDoc> udList = query.asList();
			for (UserDoc ud : udList) {
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

			log.info(userList.size() + " users retrieved");

			return new DBResponse(DBStatus.SUCCESS, userList);

		} catch (Exception ex) {
			
			log.error(ExceptionUtils.getStackTrace(ex));
			
		}
		
		return null;
		
	}
	
	public DBResponse getUserByName(String username) {
		
		Datastore ds = MongoConnect.getConnection();
		if (ds == null) {
			return new DBResponse(DBStatus.CONNECTION_FAILED);
		}
		
		Query<UserDoc> query = ds.createQuery(UserDoc.class).filter("username", username);
		
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
		
		log.info("Found " + uList.size() + " user profiles for username '" + username + "'");
		
		return new DBResponse(DBStatus.SUCCESS, uList);
		
	}
	
	public DBResponse updateUserByUsername(User user) {
		
		Datastore ds = MongoConnect.getConnection();
		if (ds == null) {
			return new DBResponse(DBStatus.CONNECTION_FAILED);
		}
		
		Query<UserDoc> query = ds.createQuery(UserDoc.class).filter("username", user.getUsername());
		UpdateOperations<UserDoc> update = ds.createUpdateOperations(UserDoc.class);
		update.set("password", user.getPassword());
		update.set("email", user.getEmail());
		update.set("role", user.getRole());
		update.set("last_updated", new Date());
		
		UpdateResults result = ds.update(query, update);
		int updated = result.getUpdatedCount();
		
		log.info("Updated " + updated + " users");
		
		if (updated > 0) {
			return new DBResponse(DBStatus.SUCCESS, updated);
		} else {
			return new DBResponse(DBStatus.NOT_FOUND);
		}
		
	}
	
	public DBResponse updateUserById(User user) {

		Datastore ds = MongoConnect.getConnection();
		if (ds == null) {
			return new DBResponse(DBStatus.CONNECTION_FAILED);
		}

		Query<UserDoc> query = ds.createQuery(UserDoc.class).filter("_id", new ObjectId(user.getId()));
		UpdateOperations<UserDoc> update = ds.createUpdateOperations(UserDoc.class);
		update.set("username", user.getUsername());
		update.set("password", user.getPassword());
		update.set("email", user.getEmail());
		update.set("role", user.getRole());
		update.set("last_updated", new Date());

		UpdateResults result = ds.update(query, update);
		int updated = result.getUpdatedCount();

		log.info("Updated " + updated + " users");

		return new DBResponse(DBStatus.SUCCESS, updated);

	}
	
}
