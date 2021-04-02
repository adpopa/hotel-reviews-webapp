package group14.app.dao;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.ValidationExtension;
import org.springframework.stereotype.Repository;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Repository
public class MongoConnectionManager {

	private static final MongoConnectionManager INSTANCE = new MongoConnectionManager();

	private static final String DB_NAME="hotel_reviews";
	
	String uri = "mongodb://hotel_reviews:coursework@cluster0-shard-00-00-ppnnz.mongodb.net:27017,cluster0-shard-00-01-ppnnz.mongodb.net:27017,cluster0-shard-00-02-ppnnz.mongodb.net:27017/?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true";

	private Morphia morphia = null;
	private Datastore datastore = null;
	private MongoClient mongoClient = null;
	
	private MongoConnectionManager() {
		morphia = new Morphia();
		new ValidationExtension(morphia);
		
		MongoClientURI client_uri=new MongoClientURI(uri);
		mongoClient=new MongoClient(client_uri);
		datastore = morphia.createDatastore(mongoClient, DB_NAME);
	}
	
	
	public static MongoConnectionManager getInstance() {
		return INSTANCE;
	}

	
	public Morphia getMorphia() {
		return morphia;
	}
	
	public void setMorphia(Morphia morphia) {
		this.morphia=morphia;
	}

	public Datastore getDatastore() {
		return datastore;
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	
	
   
	

         
}
