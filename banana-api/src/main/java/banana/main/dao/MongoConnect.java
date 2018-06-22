package banana.main.dao;

import org.jboss.logging.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public abstract class MongoConnect {

	private static String url = "mongodb://coco:fireandblood@bananarama-shard-00-00-gnmw7.gcp.mongodb.net:27017,"
			+ "bananarama-shard-00-01-gnmw7.gcp.mongodb.net:27017,bananarama-shard-00-02-gnmw7.gcp.mongodb.net:27017/test?"
			+ "ssl=true&replicaSet=bananarama-shard-0&authSource=admin&retryWrites=true";
	private static String database = "pos";
	private static Datastore ds;
	
	public static Datastore getConnection() {
		return ds;
	}
	
	public void setUrl(String url) {

		//TODO: Remove hardcoding
		url = "mongodb://coco:fireandblood@bananarama-shard-00-00-gnmw7.gcp.mongodb.net:27017,"
				+ "bananarama-shard-00-01-gnmw7.gcp.mongodb.net:27017,bananarama-shard-00-02-gnmw7.gcp.mongodb.net:27017/test?"
				+ "ssl=true&replicaSet=bananarama-shard-0&authSource=admin&retryWrites=true";
		
	}

	public void setDatabase(String db) {
		
		//TODO: Remove hardcoding
		database = "pos";
	
	}

	private static MongoClientURI cloudUriv34 = new MongoClientURI(url);
	private static MongoClient mongoClient = new MongoClient(cloudUriv34);
	
	public static void connect() {
		
		Logger log = Logger.getLogger(MongoConnect.class);
		
		Morphia morphia = new Morphia();
		morphia.mapPackage("banana.main.db.map");
		
		log.info("Connecting to DB: " + url + ", Datastore=" + database);
		ds = morphia.createDatastore(mongoClient, database);
		ds.ensureIndexes();
		
	}
	
}
