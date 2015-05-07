package sc.dao;

import org.apache.log4j.Logger;
import org.bson.Document;

import sc.InternalException;
import sc.constants.Const;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Basic Mongo DB operations
 * 
 * @author marina
 * 
 */
public class MongoDao {
	private static Logger log = Logger.getLogger(MongoDao.class);

	protected static MongoClient mongoClient;
	protected static MongoDatabase mongoStoreDB;
	protected static MongoCollection<Document> booksCollection;

	/**
	 * initialize Mongo CLient for reuse as it is multithreaded 
	 */
	protected void initMongo() {
		if (mongoClient != null)
			return;
		synchronized (this) {
			connect();
		}
	}

	/**
    * mongo client shutdown 
    * allow for restart of connection pool in case of connection error
    */
	protected void shutdown() {
		if (mongoClient != null) {
			mongoClient.close();
			mongoClient=null;
		}
	}

	private void connect() {
		try {
			MongoClientURI connectionURI = new MongoClientURI(
					Const.MONGO_CONNECT_STR);
			mongoClient = new MongoClient(connectionURI);
			mongoStoreDB = mongoClient.getDatabase(Const.MONGO_STORE_DB);
			booksCollection = mongoStoreDB
					.getCollection(Const.MONGO_BOOKS_COLLECTION);
		} catch (Exception e) {
			log.error(Const.MONGO_CONNECT_ERROR, e);
			throw new InternalException(Const.MONGO_CONNECT_ERROR);
		}
	}
}
