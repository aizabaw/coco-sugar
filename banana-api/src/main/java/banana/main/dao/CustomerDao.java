package banana.main.dao;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.mongodb.WriteResult;

import banana.db.utils.LogUtil;
import banana.main.dao.DBResponse.DBStatus;
import banana.main.db.map.CustomerDoc;
import banana.main.objects.Customer;

public class CustomerDao {
	
	private Logger log = Logger.getLogger(CustomerDao.class);
	
	public DBResponse insertCustomer(Customer cust) {
		
		Datastore ds = MongoConnect.getConnection();
		CustomerDoc cDoc = new CustomerDoc();
		cDoc.setName(cust.getName());
		cDoc.setAddress(cust.getAddress());
		cDoc.setContactNo(cust.getContactNumber());
		cDoc.setEmail(cust.getEmail());
		cDoc.setDateCreated(new Date());
		cDoc.setLastUpdated(new Date());
		
		Key<CustomerDoc> c = ds.save(cDoc);
		
		DBResponse dbResp;
		if (c != null && c.getId() != null) {
			dbResp = new DBResponse(DBStatus.SUCCESS, c.getId());
		} else {
			dbResp = new DBResponse(DBStatus.FAILED);
		}
		
		log.info(LogUtil.formatDBLog("insertCustomer", cust, dbResp));
		return dbResp;		
		
	}
	
	public DBResponse updateCustomerById(Customer cust) {
		
		Datastore ds = MongoConnect.getConnection();
		Query<CustomerDoc> query = ds.createQuery(CustomerDoc.class).filter("_id =", cust.getId());
		UpdateOperations<CustomerDoc> update = ds.createUpdateOperations(CustomerDoc.class)
				.set("name", cust.getName())
				.set("address", cust.getAddress())
				.set("contact_no", cust.getContactNumber())
				.set("email", cust.getEmail())
				.set("last_updated", cust.getLastUpdated());
		
		UpdateResults result = ds.update(query, update);
		
		DBResponse dbResp;
		if (result.getUpdatedCount() > 0) {
			dbResp = new DBResponse(DBStatus.SUCCESS, result.getUpdatedCount());
		} else {
			dbResp = new DBResponse(DBStatus.NOT_FOUND, result.getUpdatedCount());
		}
		
		
		log.info(LogUtil.formatDBLog("updateCustomerById", cust, dbResp));
		return dbResp;
		
	}
	
	public DBResponse deleteCustomerById(Object custId) {
		
		Datastore ds = MongoConnect.getConnection();
		Query<CustomerDoc> query = ds.createQuery(CustomerDoc.class).filter("_id =", custId);
		
		WriteResult result = ds.delete(query);
		
		DBResponse dbResp;
		if (result.getN() > 0) {
			dbResp = new DBResponse(DBStatus.SUCCESS, result.getN());
		} else {
			dbResp = new DBResponse(DBStatus.NOT_FOUND, result.getN());
		}
		log.info(LogUtil.formatDBLog("deleteCustomerById", custId, dbResp));
		return dbResp;
		
	}
	
	public DBResponse getCustomerById(Object custId) {
		
		Datastore ds = MongoConnect.getConnection();
		Query<CustomerDoc> query = ds.createQuery(CustomerDoc.class).filter("_id =", custId);
		
		List<CustomerDoc> custList = query.asList();
		
		DBResponse dbResp;
		if (custList.size() > 0) {
			dbResp = new DBResponse(DBStatus.SUCCESS, custList);
		} else {
			dbResp = new DBResponse(DBStatus.NOT_FOUND);
		}
		log.info(LogUtil.formatDBLog("getCustomerById", custId, dbResp));
		return dbResp;
		
	}
	
	public DBResponse getCustomerByName(String custName) {
		
		Datastore ds = MongoConnect.getConnection();
		Query<CustomerDoc> query = ds.createQuery(CustomerDoc.class).search("name", custName);
		List<CustomerDoc> cList = query.asList();
		
		DBResponse dbResp;
		if (cList.size() > 0) {
			dbResp = new DBResponse(DBStatus.SUCCESS, cList);
		} else {
			dbResp = new DBResponse(DBStatus.NOT_FOUND);
		}
		log.info(LogUtil.formatDBLog("getAllCustomers", null, dbResp));
		return dbResp;
		
	}
	
	public DBResponse getAllCustomers() {
		
		Datastore ds = MongoConnect.getConnection();
		Query<CustomerDoc> query = ds.createQuery(CustomerDoc.class);
		List<CustomerDoc> cList = query.asList();
		
		DBResponse dbResp;
		if (cList.size() > 0) {
			dbResp = new DBResponse(DBStatus.SUCCESS, cList);
		} else {
			dbResp = new DBResponse(DBStatus.NOT_FOUND);
		}
		log.info(LogUtil.formatDBLog("getAllCustomers", null, dbResp));
		return dbResp;
		
	}

}
