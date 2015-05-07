package sc.constants;

/**
 * Constants used for the shopping cart project
 * 
 */
public class Const {

	/**
	 * configure deployment for Tomcat or JBoss if false, deploy to JBoss eap
	 * 6.3 The only difference between the 2 deployments is the servlet mapping
	 * which is "/" for Tomcat but "/*" for JBoss eap 6.3
	 */
	public static final boolean DEPLOY_TOMCAT = false;

	/*
	 * to use replica group public static final String mongoConnectStr =
	 * "mongodb://localhost:27017,localhost:27018,localhost:27019";
	 */
	public static final String MONGO_CONNECT_STR = "mongodb://localhost:27017";
	public static final String MONGO_STORE_DB = "store";
	public static final String MONGO_BOOKS_COLLECTION = "books";

	public static final String MONGO_CONNECT_ERROR = "Mongo Connection Failure";
	public static final String MONGO_DATA_FETCH_ERROR = "Mongo data extraction failed.";
	public static final String MONGO_DATA_INSERT_ERROR = "Mongo data insertion failed.";
	public static final String REST_SERVICE_ERROR = "REST Service Unavailable";
}
