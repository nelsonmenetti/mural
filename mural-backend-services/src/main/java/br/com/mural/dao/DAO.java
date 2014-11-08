/*
 * Pearson All Rights Reserved
 * Nelson Fernando da Silva Menetti - Developer 
 */
package br.com.mural.dao;

import java.net.UnknownHostException;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import br.com.mural.util.PropertiesUtil;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * The Class DAO.
 */
public class DAO<T>  {

	
	/** The mongo uri. */
	private String mongoURI = "";
	
	/** The use fake connection. */
	private boolean useFakeConnection =false;
	
	/** The fake connection. */
	private static DB fakeConnection = null;
	
	private static DB realConnection = null;

	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws UnknownHostException the unknown host exception
	 */
	public Jongo getConnection() throws UnknownHostException{
		mongoURI = PropertiesUtil.getMongoPropertie(PropertiesUtil.MONGO_URI);		
		useFakeConnection = new Boolean(PropertiesUtil.getMongoPropertie(PropertiesUtil.USE_FAKE));
		DB db = null;
		if(useFakeConnection){
			db = fakeConnection;			
		}
		else{
			if(realConnection == null){
				MongoClientURI uri =  new MongoClientURI(mongoURI);
				MongoClient mongoClient = new MongoClient(uri);
				realConnection = mongoClient.getDB(PropertiesUtil.getMongoPropertie(PropertiesUtil.DB_NAME));
			}
			db = realConnection;
		}
		Jongo jongo = new Jongo(db);
		return jongo;
		
	}



	/**
	 * Gets the fake connection.
	 *
	 * @return the fake connection
	 */
	public static DB getFakeConnection() {
		return fakeConnection;
	}



	/**
	 * Sets the fake connection.
	 *
	 * @param fakeConnection the new fake connection
	 */
	public static void setFakeConnection(DB fakeConnection) {
		DAO.fakeConnection = fakeConnection;
	}
	
	/**
	 * Find.
	 *
	 * @param id
	 *            the id
	 * @return the package content
	 * @throws UnknownHostException
	 *             the unknown host exception
	 */
	@SuppressWarnings("unchecked")
	public T find(String id) throws UnknownHostException {
		T result = null;
		Jongo jongo = null;
		jongo = getConnection();
		MongoCollection mongoList = jongo.getCollection((((Class<T>)DAO.class).getName()));
		Iterable<T> foundList = mongoList.find("{_id: #}",new ObjectId(id)).as(((Class<T>)DAO.class));
		if (foundList.iterator().hasNext()) {
			result = foundList.iterator().next();
		}
		return result;
	}
	
	
	/**
	 * Save or update a Package.
	 *
	 * @param packageContent
	 *            the package content
	 * @return the package content
	 * @throws UnknownHostException
	 *             the unknown host exception
	 */
	@SuppressWarnings("unchecked")
	public T saveOrUpdate(T t)
			throws UnknownHostException {
		Jongo jongo = null;
		jongo = getConnection();
		MongoCollection mongoList = jongo.getCollection((((Class<T>)DAO.class).getName()));
		mongoList.save(t);
		return t;
	}
	
	
	/**
	 * Delete a Package.
	 *
	 * @param packageContent
	 *            the package content
	 * @throws UnknownHostException
	 *             the unknown host exception
	 */
	@SuppressWarnings("unchecked")
	public void delete(String id)
			throws UnknownHostException {
		Jongo jongo = null;
		jongo = getConnection();
		MongoCollection mongoList = jongo.getCollection((((Class<T>)DAO.class).getName()));
		mongoList.remove(new ObjectId(id));
	}
	
	
}
